/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchpage;

/**
 *
 * @author user
 */
public class PageWithWeight implements Comparable<PageWithWeight> {
    int pageNumber;
    double totalWeight;
    
    public int getPageNumber(){
        return pageNumber;
    }
    
    public void setPageNumber(int pageNumber){
        this.pageNumber = pageNumber;
    }
    
    public double getTotalWeight(){
        return totalWeight;
    }
    
    public void setTotalWeight(double totalWeight){
        this.totalWeight = totalWeight;
    }
    
    @Override
    public int compareTo(PageWithWeight p){
        double weight = p.getTotalWeight();
        if(this.totalWeight - weight == 0)
            return 0;
        if(this.totalWeight - weight < 0)
            return 1;
        return -1;
    }

}