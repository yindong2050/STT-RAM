package com.java.ga;

import java.util.*;

public class GeneticAlgorithm {

    TTUtil ttUtil;

    public GeneticAlgorithm(TTUtil ttUtil) {
        this.ttUtil = ttUtil;
    }

    private static final Random random = new Random();

    // Initial population
    public List<List<Integer>> initializePopulation(int populationSize) {
        int codeSize = 1 << ttUtil.getCodeLen();
        List<List<Integer>> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            List<Integer> individual = new ArrayList<>();
            for (int j = 0; j < codeSize; j++) {
                individual.add(j);
            }
            Collections.shuffle(individual);
            population.add(individual);
        }
        return population;
    }

    // Selection operation
    public List<List<Integer>> select(List<List<Integer>> population, List<Double> fitnesses) {
        List<List<Integer>> selected = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            double totalFitness = fitnesses.stream().mapToDouble(f -> f).sum();
            double value = random.nextDouble() * totalFitness;
            double cumulative = 0;
            for (int j = 0; j < population.size(); j++) {
                cumulative += fitnesses.get(j);
                if (cumulative > value) {
                    selected.add(population.get(j));
                    break;
                }
            }
        }
        return selected;
    }

    // Partially Matched Crossing（PMX）
    public List<List<Integer>> crossover(List<Integer> parent1, List<Integer> parent2) {
        int size = parent1.size();
        int cxPoint1 = random.nextInt(size - 1);
        int cxPoint2 = cxPoint1 + random.nextInt(size - cxPoint1);
        List<Integer> child1 = new ArrayList<>(parent1);
        List<Integer> child2 = new ArrayList<>(parent2);

        for (int i = cxPoint1; i <= cxPoint2; i++) {
            int temp1 = child1.get(i);
            int temp2 = child2.get(i);
            int index1 = child1.indexOf(temp2);
            int index2 = child2.indexOf(temp1);
            child1.set(index1, temp1);
            child2.set(index2, temp2);
            child1.set(i, temp2);
            child2.set(i, temp1);
        }
        List<List<Integer>> offspring = new ArrayList<>();
        offspring.add(child1);
        offspring.add(child2);
        return offspring;
    }

    // Exchange Variation
    public void mutate(List<Integer> individual, double mutationRate) {
        for (int i = 0; i < individual.size(); i++) {
            if (random.nextDouble() < mutationRate) {
                int j = random.nextInt(individual.size());
                Collections.swap(individual, i, j);
            }
        }
    }

    // Main Process
    public List<Integer> geneticAlgorithm(int populationSize, int generations, double mutationRate, List<Transition> transitions) {

        List<List<Integer>> population = initializePopulation(populationSize);
        List<Integer> bestIndividual = null;
        Transition bestTrans = new Transition(0, 0, 0, Integer.MAX_VALUE);

        for (int gen = 0; gen < generations; gen++) {
            List<Double> fitnesses = new ArrayList<>();
            for (List<Integer> individual : population) {
                Transition tts = ttUtil.methodTransition(individual);
                fitnesses.add(1.0 / (tts.tt + 0.001));

                if (tts.tt < bestTrans.tt || tts.tt == bestTrans.tt && tts.cost() < bestTrans.cost()) {
                    bestTrans = tts;
                    bestIndividual = individual;
                }
            }
            transitions.add(bestTrans); // Record the Optimal Sequence for Each Iteration

            List<List<Integer>> newPopulation = new ArrayList<>();
            for (int i = 0; i < populationSize / 2; i++) {
                List<List<Integer>> parents = select(population, fitnesses);
                List<List<Integer>> offspring = crossover(parents.get(0), parents.get(1));
                mutate(offspring.get(0), mutationRate);
                mutate(offspring.get(1), mutationRate);
                newPopulation.addAll(offspring);
            }

            population = newPopulation;

            if (gen % 100 == 0) {
                System.out.println("[" + gen + "]" + bestTrans);
            }

            if (bestTrans.tt == 0) {
                break;
            }
        }

        for (List<Integer> individual : population) {
            Transition t = ttUtil.methodTransition(individual);
            if (t.tt < bestTrans.tt || t.tt == bestTrans.tt && t.cost() < bestTrans.cost()) {
                bestTrans = t;
                bestIndividual = individual;
            }
        }
        transitions.add(bestTrans); // Record the Optimal Sequence for Each Iteration
        return bestIndividual;
    }

    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("args: <m> <n> <population size> <generations> <mutation rate>");
            System.exit(0);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int populationSize = Integer.parseInt(args[2]);
        int generations = Integer.parseInt(args[3]);
        double mutationRate = Double.parseDouble(args[4]);

        TTUtil util = new TTUtil(m, n);
        GeneticAlgorithm genetic = new GeneticAlgorithm(util);
        List<Transition> bestTts = new ArrayList<>();
        List<Integer> bestMethod = genetic.geneticAlgorithm(populationSize, generations, mutationRate, bestTts);
        Transition trans = util.methodTransition(bestMethod);
        System.out.println("Optimal Sequence: " + bestMethod);
        System.out.println("Minimum TT: " + trans);
    }
}
