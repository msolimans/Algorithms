package com.leetcode;

//e_811_SubdomainVisitCount 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;
import sun.jvm.hotspot.memory.DictionaryEntry;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
//
//Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
//
//We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
//
//Example 1:
//Input:
//["9001 discuss.leetcode.com"]
//Output:
//["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
//Explanation:
//We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
//
//Example 2:
//Input:
//["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
//Output:
//["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
//Explanation:
//We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
//
//Notes:
//
//The length of cpdomains will not exceed 100.
//The length of each domain name will not exceed 100.
//Each address will have either 1 or 2 "." characters.
//The input count in any count-paired domain will not exceed 10000.
//The answer output can be returned in any order.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/subdomain-visit-count/
//******************************************************************************************************************

public class e_811_SubdomainVisitCount {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new e_811_SubdomainVisitCount().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}).toArray()));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        //map domain to their counts
        Map<String, Integer> dict = new HashMap<>();


        for (String domain : cpdomains) {
            //get domain details, split by whitespace
            String[] domainDetails = domain.split("\\s");
            //parse its count [no of visits]
            int times = Integer.parseInt(domainDetails[0]);
            //extract domain parts
            for (String d : getDomainParts(domainDetails[1])) {
                //update the count
                dict.put(d, dict.getOrDefault(d, 0) + times);
            }
        }


        //results array
        List<String> result = new ArrayList<>();

        //loop thru dictionary and add to results
        for (String key : dict.keySet()) {
            result.add(dict.get(key) + " " + key);
        }

        return result;

    }


    List<String> getDomainParts(String domain) {
        List<String> result = new ArrayList<>();

        //add whole domain
        result.add(domain);

        //add parts of domain
        for (int i = domain.length() - 1; i >= 0; i--) {
            if (domain.charAt(i) == '.') {
                result.add(domain.substring(i + 1));
            }
        }

        return result;
    }

    @Test
    public void TestGetDomainParts() {
        Assert.assertEquals(Arrays.toString(new String[]{"algorithms.msoliman.me", "me", "msoliman.me"}), Arrays.toString(getDomainParts("algorithms.msoliman.me").toArray()));
    }

    @Test
    public void TestSubdomainVisits() {

        Assert.assertEquals(Arrays.toString(new String[]{"951 com", "900 google.mail.com", "1 intel.mail.com", "5 org", "5 wiki.org", "901 mail.com", "50 yahoo.com"}),
                Arrays.toString(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}).toArray()));

    }
}
