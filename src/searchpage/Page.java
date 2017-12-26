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
public class Page{
  ArrayList<String> keywords = new ArrayList<String>();

  public ArrayList<String> getKeywords(){
    return keywords;
  }

  public void setKeywords(ArrayList<String> keywords){
    this.keywords = keywords;
  }
}

