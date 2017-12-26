/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchpage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class SearchPage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        String[] input={"P Ford Car Review","P Review Car","P Review Ford",
                        "P Toyota Car","P Honda Car","P Car","Q Ford","Q Car",
                        "Q Review","Q Ford Review","Q Ford Car","Q cooking French"};

        List<Page> pages = new ArrayList<>();
        List<Query> queries = new ArrayList<>();

        for (String input1 : input) {
            if (input1.charAt(0) == 'P') {
                Page newPage = new Page();
                ArrayList<String> keywords = new ArrayList<>();
                String[] words = input1.split("\\s");
                for (String word : words) {
                    if (!(word.equals("P"))) {
                        keywords.add(word);
                    }
                }
                newPage.setKeywords(keywords);
                pages.add(newPage);
            } else if (input1.charAt(0) == 'Q') {
                Query newQuery = new Query();
                ArrayList<String> keywords = new ArrayList<>();
                String[] words = input1.split("\\s");
                for (String word : words) {
                    if (!(word.equals("Q"))) {
                        keywords.add(word);
                    }
                }
                newQuery.setKeywords(keywords);
                queries.add(newQuery);
            }
        }

        for(int i=0; i<queries.size(); i++){
            List<PageWithWeight> pageWithWeights = new ArrayList<>();
            for(int j=0; j<pages.size(); j++){
                PageWithWeight weightedPage = queries.get(i).calculateWeight(j, pages.get(j), 8);
                pageWithWeights.add(weightedPage);
            }
            Collections.sort(pageWithWeights);
            System.out.print("Q"+ (i+1)+":\t");
            for(int k=0,index=0;k<5 && index<pageWithWeights.size();index++){
                if(pageWithWeights.get(index).getTotalWeight()>0){
                    System.out.print("P" + (pageWithWeights.get(index).getPageNumber()+1)+"\t");
                    k++;
                }
            }
            System.out.println();
        }
      }
    
}
