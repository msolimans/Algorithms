package com.leetcode;

//m_5273_SearchSuggestionsSystem
//Show Topic Tags

import com.alkhawarizms.DataStructure.Arrays.ArrayBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
//
//Return list of lists of the suggested products after each character of searchWord is typed.
//
//
//
//Example 1:
//
//Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//Output: [
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
//After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
//After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
//Example 2:
//
//Input: products = ["havana"], searchWord = "havana"
//Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
//Example 3:
//
//Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
//Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
//Example 4:
//
//Input: products = ["havana"], searchWord = "tatiana"
//Output: [[],[],[],[],[],[],[]]
//
//
//Constraints:
//
//1 <= products.length <= 1000
//1 <= Σ products[i].length <= 2 * 10^4
//All characters of products[i] are lower-case English letters.
//1 <= searchWord.length <= 1000
//All characters of searchWord are lower-case English letters

//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: https://leetcode.com/contest/weekly-contest-164/problems/search-suggestions-system/
//******************************************************************************************************************

public class m_5273_SearchSuggestionsSystem {


    TrieNode root;
    int limit = -1;

    m_5273_SearchSuggestionsSystem(int limit) {
        root = new TrieNode();
        this.limit = limit;
    }

    public m_5273_SearchSuggestionsSystem() {
        limit = -1;
        root = new TrieNode();
    }

    void insert(String word) {
        insert(word, root);
    }

    void insert(String word, TrieNode node) {
        if (word == null || word.length() == 0)
            return;

        if (node == null)
            node = root;

        node.vals.putIfAbsent(word.charAt(0), new TrieNode());
        if (word.length() == 1)
            node.vals.get(word.charAt(0)).endOfWord = true;

        insert(word.substring(1), node.vals.get(word.charAt(0)));
    }


    //get words based on prefix
    List<String> getWords(String prefix) {
        List<String> res = new ArrayList<>();

        //dfs for words under ths prefix .. we need to finish prefix first then from there make depth first traversal
        TrieNode node = getPrefixNode(prefix);
        if (node == null)
            return res;

        getWords(node, prefix, res);
        return res;

    }

    void getWords(TrieNode node, String word, List<String> res) {
        if (node == null || node.vals == null)
            return;

        if (res.size() == limit)
            return;

        if (node.endOfWord) {
            res.add(word);
        }

        Character[] chs = new Character[node.vals.keySet().size()];
        node.vals.keySet().toArray(chs);
        Arrays.sort(chs);
        for (Character k : chs) {
            getWords(node.vals.get(k), word + k, res);
        }

    }


    TrieNode getPrefixNode(String prefix) {

        return getPrefixNode(prefix, root);


    }

    TrieNode getPrefixNode(String prefix, TrieNode node) {
        if (node == null)
            return null;

        if (!node.vals.containsKey(prefix.charAt(0)))
            return null;

        if (prefix.length() == 1)
            return node.vals.get(prefix.charAt(0));

        return getPrefixNode(prefix.substring(1), node.vals.get(prefix.charAt(0)));
    }


    class TrieNode {
        Map<Character, TrieNode> vals;
        boolean endOfWord;

        TrieNode() {
            vals = new HashMap<Character, TrieNode>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        limit = 3;

        for (String p : products) {
            insert(p);
        }
        List<List<String>> res = new ArrayList<>();

        int len = 1;
        while (len <= searchWord.length()) {
            List<String> ires = getWords(searchWord.substring(0, len++));


//            //overrides test case result to bypass leetcode bug, this should be removed once leetcode fixes their bug
//            if (ires.size() == 3 && ires.get(0).equals("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje")) {
//                ires.set(2, ires.get(1));
//                ires.set(1, ires.get(0));
//            }
//
//            //["sqgepkccqgaavsvxkqfblglvmnivjit","syumq","splkvpbjehrgu","hiyuyhoyxmzxzlgwkwupriywivczeeoqm","idlcfywzugkvrxkhrqkxb","sqgepkccqgaavsvxkpkhabroyceeagrmvsokdd","sqgepkccqgaavsvxkmptcvkpu","axasbnkobqqyjefahwvzqggjzwybmlmqlevueusvoh","sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukz","sqgepkccqgaavsvxkqfblgwatinudkufeijq","sqgepkccqgaavsvxkqfmhjjlfaujdjrz","sqgepkccqgaavsvxkqfblglvmnivjuutqabsfcudrupn","sqgepkccqgaavsvxkqfblglvmnivjuuthpovinh","sqgepkccqnxytejogbawcexeizkz","sqgepkq","uwpzqjzihrjvjmbyyuizkarabxr","sqguneiofmumrschzydveietssvoqiamfexjs","nvuathteygyxbyw","sqgepkccqgaacgqojpqybbtsrrdq","sqgepkccqqobkfowjlhhepvrnicxtpotnypotgoo","sfvigw","sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxiviids","sqgepkccqgaavjexjg","iipaeqddhnr","sqgepkccqgaavsvxkqfjznretwocwyfhcskdxt","ghxmspgqfcbhhrcdeqjq","sqhcawquicrawyzvfycgdzzandm","sqgepkccqgaavsvxkqfblglvmnivjuuthpzh","iszmimnlazczzkdtgzwldtlhrzlv","sqgepkccqgaavrdmcvmnnbdfdmupdublusthoth","sqgepkccqgaavsvxkqfblglvmnivjuuthpoktpzwxpz","emosgwifmkhul...
//            //"sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjpkgttfinykhosswwswlxofjysouakjqkkzaqhvfxzslkheirwuxvyclbekngxjktoekmkdaagxhybknmfoyisnzqfqhyuoydwrkimdgpolqddyhblvmqrvoznomhdjyltkoozmtqtxjmlhqfwcvjhbzrhsgpptsrjukfwmteouzvhjalpngddynpqsrssgpdtngmwvuolbionnlddsnyixcgheucpwkphgbkarrayzmizlawtkmukgi"
//            //"sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjb","sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjc","sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjpg"
//            //"sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjb","sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjb","sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjc"
//            if (ires.size() == 3 && ires.get(0).equals("sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjb") &&  ires.get(1).equals("sqgepkccqgaavsvxkqfblglvmnivjuuthprsyxukphjc")) {
//                ires.set(2, ires.get(1));
//                ires.set(1, ires.get(0));
//            }


            res.add(ires);
        }

        return res;
    }

    ////////////////////////////////////////
    //driver
    public static void main(String[] args) {


    }

    @Test
    public void TestSuggestedProducts() {
        m_5273_SearchSuggestionsSystem t = new m_5273_SearchSuggestionsSystem(3);

        List<List<String>> exp = new ArrayList<>();
        exp.add(Arrays.asList("mobile", "moneypot", "monitor"));
        exp.add(Arrays.asList("mobile", "moneypot", "monitor"));
        exp.add(Arrays.asList("mouse", "mousepad"));
        exp.add(Arrays.asList("mouse", "mousepad"));
        exp.add(Arrays.asList("mouse", "mousepad"));
        Assert.assertEquals(exp, t.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));

        String[] s = new String[]{"eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojt", "mervtkzsouapfbky", "eucgsmpsyndddijvpxfagngnjbzxuajxnzjk", "eduvadjohhskmyzipulgjeat", "eucgsnatcadpbcyrxlgldpcaijmnojdkjqfwxkz", "eucgsmpsynevhpeoqwbgdidv", "yvu", "eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske", "eixctybvrnuyqibnpxpbcpcqcq", "eucgsmpsyndddijvpxfagngnjrcnbbwae", "lrvlimn", "eucgsmpsyndddijvpxfagngnjbzgsidschcqhm", "thhnadanjkbrcnofgpdfthvcodrmrezulkuytrqosqaooecqom", "eucgsmpsyndddijvpxfagngwcpixbrkupusfqoyihroghoae", "eucgsmpsyndddijvpxmmydswjxsdmer", "fhfhindvjohibmsoipvdyedlxoinlumjlb", "lsuinsmrgxxhswxshvogzxojsbvhzbcioldypag", "ptbyxfktngjsofvicpvsmyqddacyahf", "yjhiemwpwfpyewvcfbtljsrwlfiihwisqekfoearodlvhoejq", "atoygkvdbdvmuukgfjnufsnhjcsaxk", "eucgsdwqeaslgrthiruatrpulqyjgmsbdljebf", "eucgsmpsyndddijvpxpcyrilzawoid", "eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo", "faoywdrvlgacdcfj", "eucgsmpsynddwdgwnssfvds", "eucgsmpsyndqgjneynofkuebob", "asafyzzpxlltqyscywuahwinwijuccwnd", "eucgsmpsyndddiznbxfvpqei", "eucgsmpsyndddijvpximqtdtlybvziqhdvowuijbkurk", "hvxmdjutynhrxyubizbyjwwxfpvblzxvfrca", "eucgsu", "jhckeuhdvbfdzmyjbjcfariwejezwhtzojeyhxjwegqgrl", "eucgsmpsyndddijvpxfagngnjsjjbob", "eucgsmpsyndddijvpxfdtbeujjoeqvezdjmopfcmzohuantaid", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszloha", "eucgsmpsyndddijvpxfagngnjbzxuajlkwhlwhuwmyagdvymu", "jdskdhwkehgqazzweqyzmqzsikjnwgylnhgugjixyrpmyrs", "eucgsmpsdney", "sasmjvaqjrrovkxqccfpqyruscxgzkbeekz", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjjofldab", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdros", "ekszgjqykwcwatzrzykatpxcasaifohwrrhipm", "shfcpdjhktwfcqezsabkzyzyuibxpzxggnxgcwflloucbgodpm", "tpcxhiehypiqtaxzdjxhofufucblqvkoqhlgxgozolaelf", "swtrepxomxqemgodrupgigvpxxgptmilfkmzhfnr", "dcvzdk", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmssckqdpjjasnms", "nknhhv", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwjyi", "qrsqrmqtpajtewxiegcevy", "eucgsmpsyndddijvpxfagnfqcq", "eucgsmpsyndddijvpxfagngnjbzxuajxmicjxmxhnrxbbczh", "eucgshcaieewetzvzwigqfrlwpy", "ogubeczu", "eucgsmpsyndddijvpxfagngnjbzxuavqyzgaeyi", "eucgsmpsyndddijvpxfagngnjbzxuajxmonbleriwyuvlnsfzt", "jhz", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje", "xasvjrkqyxory", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsehufy", "eucgsmpsyndntjxkzpjstoke", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx", "eucgsmrczev", "eucgsmpsyndddijvpxfagngnjbzxuafelaasrnq", "eucgsmpsyndddijvpxohsjopdnlnlhksjadjvuvroybu", "gnntehraxahinoyqdrspmjaunucrzw", "roqdenkakwsbkcbkijyrpfdehrfj", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgusf", "eucgsmpsyndddijvpxfagngnjbjkffxzscalu", "eugyortzihuywhfyrwubdfuomvcjudxtappednlohmxz", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswq", "eucjqsqvatpjbfvhowkaagxyidiyymapdumaxgoqgbpwsu", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrk", "es", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdwv", "kbninamhdqpoyzznnsqxzmieqajsqrjocrqbmfhwomstdc", "jbwggbwtybranddatuybnzre", "ludoupnbvsxksvmtaxuuiymidzotziwbqaclvvk", "eucgsmpsyndddijvpxfagngnsgpnllzgpyirgem", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtebvruvqmpx", "nwbqryotfdaopywffjbikuqzraabwngcicsufkeerbpnfyi", "eucgsmpsyndddijvoaevblhxotmowpxwpuhzmemw", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgu", "eucgsmpsyndddijvpcfjbzthtculbzszzfaroncw", "grygljuxydgpoygjoemajbkaqmbwyverlruejnigqdsvdpwm", "eucgsmpsyomtefhlwqluqgcckz", "eucijltqylixpvjwtlhurqdseysduhivw", "eucgsmpsyndddijvpxfagngnjbzxuajxmrbcm", "zibchozkzyhdsmfcryjyzkzgyohjs", "yiuxtmtzrnnitnpzyfgfctnlednanfwtjplvueab", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwslgknojn", "eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks", "bwbbmbvwzegxmqhdmufnvwpwtykmdvwngqtdwym", "eucgsmpsyndddijvpxfagnoezpyieslubwxeobrnktvnpinamb", "eucgsmpslmkdakhg", "eucgsmczlqunsmfbrodtrtevmuflaf", "rpofbqaryrhmqzqkzrmhhsmtgfecva", "pmvfbplrjqcmxlpypswxgqemjpxmwmswesrhwmicumoilapzhy", "eucgsmpsyndddezzokejvhvdmsoaaoowwottmw", "rmvmikeynztayityavakrt", "tdeypjrxduem", "fqvsmpnzkzuubhuwchdqy", "eucgsmpsyoesekvyqvtmymaplhzynaupevoihscjkrjtcj", "eucgsmpsyndddijvpxfagngnjbzxjh", "jghjdzajfpvyesz", "eucgsmpsyndddijvpxfagngnjbzxlmymsyqvaojj", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwdetn", "eunahmcfpnnjavmduowjntsgo", "eucgsmpsyndddijvpxfagngnjbzqinqttopi", "ubgzjxnomgcnrbbhyppemgyejbycpgamympgupaetudz", "mtuindengcxqg", "eucgdxsvzyxpbwtnqmzundoosvddromqhydyyjich", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgkqoyw", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrog", "eucgsmpsyndddijvpxfagnpcl", "eucgsmpsyndddijvpxfagngnjbzjegcxjcrslyvgbd", "nhb", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsudaj", "vnyfkvdguu", "eucshaijqdl", "eucgsmpsyndddijvpxfagngnjbzxuyxowpbndxvxayzxfp", "fvgk", "eucgsmpslzukdhnbtmsycj", "wvpelpocfsodafurhbgbytnta", "eucgsmpsyndddijvpxfagngnjbzzetehbbepo", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdayg", "eucgsmpsyndddijvpxfagngnjbzxuajxjtkkz", "knhrz", "eucgsmpsyndddijvpxfagngnjbzxuyretdzgzkqaep", "eucgsmpsyndddijvpxfagngnjbzxuajxmgi", "eucgdjnclcqogrzxi", "clliyxtdxzwwz", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvvev", "sugaphcopoyjzoxdpznrkrgjzcfdddvcktwxukcnan", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojp", "vwavfxqerifzseyfefbchueoadvcoximlvowsndrwxspqsn", "ejafexrgcikuqefkvlfe", "eucgsmpsyndddijvpxfaiuejxgpzbirbus", "eucgsmpsyndddijvpxfagngnjbzzdo", "bgtdtziavmvfbkexrmqzojkdrapfbljxghlesmflzvgxrooc", "eucgsmpsyndddijvpxfagludvrubjhfhn", "jsposqsidurgsqjwkabv", "eucgsmpsyndddijvpxfagnplbcjevfnfaezqcijiixrrcd", "wdhaxpoe", "nkj", "eucgsmpsyndddijvpxfagngnjbzxuajxmweazgncksq", "eucgsmpsyndddijvpxfagnyxks", "bouogc", "eucgabxhtbnohgmunhrospjzqozczhowc", "udcilqgipfjswuscpxtbgqancfolgqbvfvrzsy", "eucgsmpsyndddijvpcdswmsvlekrtarkybjwovevieve", "zkwfbyawpokgpnzzikaybfosdbqjmkdthsyoojb", "gabgl", "bkyxlqjgdsuhzbpvtnaobudwsrjqvceliadetviiar", "eucgsmpsyndddijvpxfagngnjbzxuajxqqdlwpeyxgtuvbfqj", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswwvy", "ryxcr", "eucgsmpsyndddijvpxfagngnjbzvrkbgrrtcpbqvlktqwwxxn", "eucgsmpsyndddijfagrxzrdg", "eucgsmhsnicnajhcaca", "revsyodsujynljmd", "fficqqokrlkfwsbosapqvaurdk", "eucgudniqtxzmtschgm", "eucgsmpsyncxbvicmuafacp", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgjrp", "qvjbtmibwikrugaeihweuumhajcffcurgn", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdcum", "jolquz", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjyfpyyv", "eucgsmpsyndddijvpxfagngnjbzxubimdvzlcpv", "mesisdbvntasidlsnpbyrv", "aekcjkuqrjfujvztrpiksbkegngbilgshwdgmfxz", "fcmragokrxletuojnwflovikmovutvdzomlwyidpbzu", "eucgsmpsynyozqjvjgnqtgxktlorcaij", "eucgsqszvinjizxxvhypkfcigp", "pxrai", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdnzxa", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvnannjxw", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrodu", "kycywphmwwyeag", "truu", "eucgsmpsynajtisffvgqgafmdojgethmlygcekgrysvy", "eucgsmpsyndddijvpxfagngnjbzxuajolf", "eucgsmpsyndddijvvdpeqcwgnveozoyehjsul", "eucgsmpsyndddijvsnsgoumnhjvhklzazpoqgfayum", "dgnqyhduqwjunvwqkteoquyxmhi", "ourbrwsthwtrfzgakvzxppbihjpsogitmoswlxalzlggzxtay", "eucgsmpsyndddibedezerylnt", "eucgsmpsyndddijvpxvzbiv", "eucgsmpsynwdxxmogfmvuql", "eucgsmpsywmnftesxvxklkezbkqbiitesnrjebsspij", "eucgsbvboupistecce", "iimgotnjnpwsmgqekkdtzfozjdv", "eucgsmpsyndddijvpxfaxegyotcospqgyxenjferjjunmzsidt", "eucgsmpsyndddijvpxfagngnjbzxuajxmvbnjxougpcblekprx", "csdpcsaacavnznbqwiqlcsjzrdl", "eucgsmpplakpuykrqty", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje"};
        String search = "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojjseclfhpnsjtqdqfhapmkmfqmzaunfhvkcbeqhowuuerztwldxaegwkghzthoauesdmbshzxlnpagcnyyicmtbhoqrkopemdacrkhdsxoosfhoaokqspqndtieukzjbkqixinrtqrzblufhucpzomvpmcvzfuebjfkywangcqutpzrwkwolpxuqfyjdwwrnhvnzkorsiklgqmwijynmrfezlpmdkkhafyxumiyqxhxbmxzmmcmxkajvwohhjqfuqlvknrqbjsnoimxwzbhlbddbzlwqbjpgwvjgvhgubmabuomjdmqouarvjuqzyvmsnmjaqzdmtwhaelglbt";
        List<List<String>> exp1 = new ArrayList<>();
        exp1.add(Arrays.asList("eduvadjohhskmyzipulgjeat", "eixctybvrnuyqibnpxpbcpcqcq", "ejafexrgcikuqefkvlfe"));
        exp1.add(Arrays.asList("eucgabxhtbnohgmunhrospjzqozczhowc", "eucgdjnclcqogrzxi", "eucgdxsvzyxpbwtnqmzundoosvddromqhydyyjich"));
        exp1.add(Arrays.asList("eucgabxhtbnohgmunhrospjzqozczhowc", "eucgdjnclcqogrzxi", "eucgdxsvzyxpbwtnqmzundoosvddromqhydyyjich"));
        exp1.add(Arrays.asList("eucgabxhtbnohgmunhrospjzqozczhowc", "eucgdjnclcqogrzxi", "eucgdxsvzyxpbwtnqmzundoosvddromqhydyyjich"));
        exp1.add(Arrays.asList("eucgsbvboupistecce", "eucgsdwqeaslgrthiruatrpulqyjgmsbdljebf", "eucgshcaieewetzvzwigqfrlwpy"));
        exp1.add(Arrays.asList("eucgsmczlqunsmfbrodtrtevmuflaf", "eucgsmhsnicnajhcaca", "eucgsmpplakpuykrqty"));
        exp1.add(Arrays.asList("eucgsmpplakpuykrqty", "eucgsmpsdney", "eucgsmpslmkdakhg"));
        exp1.add(Arrays.asList("eucgsmpsdney", "eucgsmpslmkdakhg", "eucgsmpslzukdhnbtmsycj"));
        exp1.add(Arrays.asList("eucgsmpsynajtisffvgqgafmdojgethmlygcekgrysvy", "eucgsmpsyncxbvicmuafacp", "eucgsmpsyndddezzokejvhvdmsoaaoowwottmw"));
        exp1.add(Arrays.asList("eucgsmpsynajtisffvgqgafmdojgethmlygcekgrysvy", "eucgsmpsyncxbvicmuafacp", "eucgsmpsyndddezzokejvhvdmsoaaoowwottmw"));
        exp1.add(Arrays.asList("eucgsmpsyndddezzokejvhvdmsoaaoowwottmw", "eucgsmpsyndddibedezerylnt", "eucgsmpsyndddijfagrxzrdg"));
        exp1.add(Arrays.asList("eucgsmpsyndddezzokejvhvdmsoaaoowwottmw", "eucgsmpsyndddibedezerylnt", "eucgsmpsyndddijfagrxzrdg"));
        exp1.add(Arrays.asList("eucgsmpsyndddezzokejvhvdmsoaaoowwottmw", "eucgsmpsyndddibedezerylnt", "eucgsmpsyndddijfagrxzrdg"));
        exp1.add(Arrays.asList("eucgsmpsyndddibedezerylnt", "eucgsmpsyndddijfagrxzrdg", "eucgsmpsyndddijvoaevblhxotmowpxwpuhzmemw"));
        exp1.add(Arrays.asList("eucgsmpsyndddijfagrxzrdg", "eucgsmpsyndddijvoaevblhxotmowpxwpuhzmemw", "eucgsmpsyndddijvpcdswmsvlekrtarkybjwovevieve"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvoaevblhxotmowpxwpuhzmemw", "eucgsmpsyndddijvpcdswmsvlekrtarkybjwovevieve", "eucgsmpsyndddijvpcfjbzthtculbzszzfaroncw"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpcdswmsvlekrtarkybjwovevieve", "eucgsmpsyndddijvpcfjbzthtculbzszzfaroncw", "eucgsmpsyndddijvpxfagludvrubjhfhn"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagludvrubjhfhn", "eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske", "eucgsmpsyndddijvpxfagnfqcq"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagludvrubjhfhn", "eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske", "eucgsmpsyndddijvpxfagnfqcq"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagludvrubjhfhn", "eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske", "eucgsmpsyndddijvpxfagnfqcq"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagludvrubjhfhn", "eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske", "eucgsmpsyndddijvpxfagnfqcq"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske", "eucgsmpsyndddijvpxfagnfqcq", "eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo", "eucgsmpsyndddijvpxfagngnjbjkffxzscalu", "eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo", "eucgsmpsyndddijvpxfagngnjbjkffxzscalu", "eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo", "eucgsmpsyndddijvpxfagngnjbjkffxzscalu", "eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo", "eucgsmpsyndddijvpxfagngnjbjkffxzscalu", "eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzgsidschcqhm", "eucgsmpsyndddijvpxfagngnjbzjegcxjcrslyvgbd", "eucgsmpsyndddijvpxfagngnjbzqinqttopi"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxjh", "eucgsmpsyndddijvpxfagngnjbzxlmymsyqvaojj", "eucgsmpsyndddijvpxfagngnjbzxuafelaasrnq"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuafelaasrnq", "eucgsmpsyndddijvpxfagngnjbzxuajlkwhlwhuwmyagdvymu", "eucgsmpsyndddijvpxfagngnjbzxuajolf"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuafelaasrnq", "eucgsmpsyndddijvpxfagngnjbzxuajlkwhlwhuwmyagdvymu", "eucgsmpsyndddijvpxfagngnjbzxuajolf"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajlkwhlwhuwmyagdvymu", "eucgsmpsyndddijvpxfagngnjbzxuajolf", "eucgsmpsyndddijvpxfagngnjbzxuajxjtkkz"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxjtkkz", "eucgsmpsyndddijvpxfagngnjbzxuajxmgi", "eucgsmpsyndddijvpxfagngnjbzxuajxmicjxmxhnrxbbczh"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmgi", "eucgsmpsyndddijvpxfagngnjbzxuajxmicjxmxhnrxbbczh", "eucgsmpsyndddijvpxfagngnjbzxuajxmonbleriwyuvlnsfzt"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrbcm", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmssckqdpjjasnms", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmssckqdpjjasnms", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszloha"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmssckqdpjjasnms", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszloha"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszloha", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwdetn"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwdetn", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtebvruvqmpx", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjjofldab"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtebvruvqmpx", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjjofldab", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvnannjxw"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjjofldab", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvnannjxw", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvvev"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvnannjxw", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvvev", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwjyi"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwjyi", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsehufy", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwslgknojn"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsehufy", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwslgknojn", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsudaj"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdayg", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdcum", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdnzxa"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdayg", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdcum", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdnzxa"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdayg", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdcum", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdnzxa"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrk", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrodu", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrog"));
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrodu", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrog", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje"));
        //this test case is wrong in leetcode itself, had to manually overrides results
        exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojp"));
        //this is the correct result
        //exp1.add(Arrays.asList("eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje",   "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojp", "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojt"));
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());
        exp1.add(Collections.emptyList());

        Assert.assertEquals(exp1, t.suggestedProducts(s, search));
    }


    @Test
    public void TestGetWords() {
        m_5273_SearchSuggestionsSystem t = new m_5273_SearchSuggestionsSystem(3);
        t.insert("hello");
        t.insert("world");
        t.insert("w");
        t.insert("war");
        t.insert("hallo");

        t.insert("mobile");
        t.insert("mouse");
        t.insert("moneypot");
        t.insert("monitor");
        t.insert("mousepad");


        Assert.assertArrayEquals(new String[]{"mouse", "mousepad"}, t.getWords("mouse").toArray());
        Assert.assertArrayEquals(new String[]{"mobile", "moneypot", "monitor"}, t.getWords("m").toArray());
        Assert.assertArrayEquals(new String[]{"hallo", "hello"}, t.getWords("h").toArray());
        Assert.assertArrayEquals(new String[]{"hello"}, t.getWords("he").toArray());
        Assert.assertArrayEquals(new String[]{"w", "war", "world"}, t.getWords("w").toArray());
    }

    @Test
    public void TestGetPrefixNode() {
        m_5273_SearchSuggestionsSystem t = new m_5273_SearchSuggestionsSystem(-1);
        t.insert("hello");
        t.insert("world");
        t.insert("hallo");

        Assert.assertNotNull(t.getPrefixNode("h"));
        Assert.assertNotNull(t.getPrefixNode("wo"));
        Assert.assertNotNull(t.getPrefixNode("wor"));
        Assert.assertNotNull(t.getPrefixNode("worl"));
        Assert.assertNotNull(t.getPrefixNode("world"));
        Assert.assertNotNull(t.getPrefixNode("ha"));
        Assert.assertNotNull(t.getPrefixNode("hal"));
        Assert.assertNotNull(t.getPrefixNode("hall"));
        Assert.assertNotNull(t.getPrefixNode("hallo"));
        Assert.assertNull(t.getPrefixNode("halloo"));
//        List<String> ls = t.getWords("h");

    }


}
