package lesson_3.candidate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by linhnm on September, 2021
 */

public class CandidateManager {
    private ArrayList<Candidate> candidates;

    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }

    /*
    readData
    doc du lieu tu file van ban textFile va luu du lieu vao cac bien thanh vien
    */
    public boolean readData(String textFile) {
        try {
            // add code here
            Scanner fileReader = new Scanner(new FileInputStream(textFile));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] contentArray = line.split("\\|");
                Candidate candidate = new Candidate(
                        contentArray[0].trim(),
                        contentArray[1].trim(),
                        contentArray[2].trim(),
                        contentArray[3].trim(),
                        Integer.parseInt(contentArray[4].trim()),
                        Integer.parseInt(contentArray[5].trim())
                );
                candidates.add(candidate);
            }
            fileReader.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Error reading file '" + textFile + "'");
            return false;
        }
    }

    /*
    getSelectionCandicates
    trả về danh sách các thí sinh có khối thi là selection
    */
    public ArrayList<Candidate> getSelectionCandicates(String selection) {
        return candidates.stream()
                .filter(candidate -> candidate.getSelection().equals(selection))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*
    getPriorityCandidates
    trả về danh sách thí sinh được ưu tiên (có độ ưu tiên bằng 1)
    */
    public ArrayList<Candidate> getPriorityCandidates() {
        return candidates.stream()
                .filter(candidate -> candidate.getPriority() == 1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*
    sortByName
    tra ve danh sach cac thi sinh duoc sap xep theo ho va ten (name)
    */
    public ArrayList<Candidate> sortByName() {
        return candidates.stream()
                .sorted(Comparator.comparing(Candidate::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*
    getSecondYoungestCandidates
    trả về danh sách các thí sinh có tuổi trẻ thứ 2 trong danh sách
    (ví dụ: các khách hàng có các năm sinh 1990 1991 1992 1993,
    trả về danh sách các khách hàng sinh năm 1992)
    */
    public ArrayList<Candidate> getSecondYoungestCandidates() {
        ArrayList<Candidate> candidatesSecondList = new ArrayList<>();
        int maxYear = findMaxYear(candidates);
        int second = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getYear() != maxYear) {
                second = candidate.getYear();
                break;
            }
        }
        for (Candidate candidate : candidates) {
            if (maxYear > candidate.getYear() && candidate.getYear() > second) {
                second = candidate.getYear();
                candidatesSecondList.clear();
                candidatesSecondList.add(candidate);
            } else if (candidate.getYear() == second) {
                candidatesSecondList.add(candidate);
            }
        }
        return candidatesSecondList;
    }

    private int findMaxYear(ArrayList<Candidate> candidates) {
        int max = candidates.get(0).getYear();
        for (Candidate candidate : candidates) {
            if (candidate.getYear() > max) max = candidate.getYear();
        }
        return max;
    }

    /*
    printCandidatesFromArray
    in danh sach cac thi sinh tu mot List da cho
    */
    public void printCandidatesFromArray(ArrayList<Candidate> candidates) {
        if (candidates == null) {
            return;
        }

        for (int i = 0; i < candidates.size(); i++) {
            candidates.get(i).print();
        }
    }

    /*
    printCandidates
    in danh cach cac thi sinh duoc luu trong bien thanh vien candidates
    */
    public void printCandidates() {
        printCandidatesFromArray(this.candidates);
    }

    public static void main(String[] args) {
        System.out.println("start app");
        CandidateManager candidateManager = new CandidateManager();
        if (candidateManager.readData("candidates.txt")) {
//            for (Candidate candidate : candidateManager.candidates) {
//                System.out.println("check");
//                System.out.println(candidate.toString());
//            }

            ArrayList<Candidate> candidateList = candidateManager.getSecondYoungestCandidates();
            for (Candidate candidate : candidateList) {
                System.out.println(candidate.toString());
            }
        }

        //ArrayList<Candidate> selectionCandidates = candidateManager.getSelectionCandicates("A");
        //candidateManager.printCandidatesFromArray(selectionCandidates);
        //System.out.println();

        //ArrayList<Candidate> priorityCandidates = candidateManager.getPriorityCandidates();
        //candidateManager.printCandidatesFromArray(priorityCandidates);
        //System.out.println();

        //ArrayList<Candidate> sortedNameCandidates = candidateManager.sortByName();
        //candidateManager.printCandidatesFromArray(sortedNameCandidates);
        //System.out.println();

        //ArrayList<Candidate> secondYoungestCandidates = candidateManager.getSecondYoungestCandidates();
        //candidateManager.printCandidatesFromArray(secondYoungestCandidates);
    }
}
