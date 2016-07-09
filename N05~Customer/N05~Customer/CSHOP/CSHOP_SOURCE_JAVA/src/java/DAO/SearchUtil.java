/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author PQC
 */
public class SearchUtil {
   
    private int totalCountries;
    private String data = "Afghanistan, Albania, Zimbabwe";
    private List<String> countries;
    public SearchUtil() throws SQLException {
        ListProduct lp= new ListProduct();
        countries = lp.GetAllData();
       
        totalCountries = countries.size();
    }
    public List<String> getData(String query) {
        String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<>();
        for(int i=0; i<totalCountries; i++) {
            country = countries.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(countries.get(i));
            }
        }
        return matched;
    }
}
