/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchpage;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Query{
  ArrayList<String> keywords = new ArrayList<String>();

  public ArrayList<String> getKeywords(){
    return keywords;
  }

  public void setKeywords(ArrayList<String> keywords){
    this.keywords = keywords;
  }
  
  public PageWithWeight calculateWeight(int pageNumber, Page p, int weightFactor){
      double sum = 0.0;
      int prod = 0;
      PageWithWeight pageWithWeight = new PageWithWeight();
      for(int i=0; i< this.getKeywords().size(); i++){
          for(int j=0; j<p.getKeywords().size(); j++){
              prod = 0;
              if(this.getKeywords().get(i).equals(p.getKeywords().get(j))){
                  prod = (weightFactor - i)*(weightFactor - j);
                  break;
              }
          }
          sum = sum + prod;
      }
        pageWithWeight.setTotalWeight(sum);
        pageWithWeight.setPageNumber(pageNumber);
        return pageWithWeight;
  }
}