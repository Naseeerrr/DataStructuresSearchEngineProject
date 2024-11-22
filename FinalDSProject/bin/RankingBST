public class Ranking_BST {

    static String Query;
    static InvertedBST inverted;
    static Index index1;
    static LinkedList<Integer> all_doc_in_query;
    static BST_int<Integer> DocIDs_withRank;  // adddd

    public Ranking_BST(InvertedBST inverted, Index index1, String Query) {
        this.inverted = inverted;
        this.index1 = index1;
        this.Query = Query;
        all_doc_in_query = new LinkedList<>();
        DocIDs_withRank = new BST_int<>();
    }

    public static void insert_sorted_inBST() {
        RankQuery(Query); // To fill all_doc_in_query
        if (all_doc_in_query.empty()) {
            System.out.println("empty query");
            return;
        }

        all_doc_in_query.findFirst();
        while (!all_doc_in_query.last()) {
            Document d = get_doc_given_id(all_doc_in_query.retrieve());
            int Rank = get_doc_rank_score(d, Query);
            DocIDs_withRank.insert(Rank, all_doc_in_query.retrieve());
            all_doc_in_query.findNext();
        }

        Document d = get_doc_given_id(all_doc_in_query.retrieve());
        int Rank = get_doc_rank_score(d, Query);
        DocIDs_withRank.insert(Rank, all_doc_in_query.retrieve());
    }

    public static void display_all_doc_with_score() {
        DocIDs_withRank.display_decreasing(); // checkkkkkk!!!
    }

    public static Document get_doc_given_id(int id) {
        return index1.get_doc(id);
    }

    public static int term_frequency_in_doc(Document d, String term) {
        int freq = 0;
        LinkedList<String> words = d.word;
        if (words.empty()) return 0;
        words.findFirst();
        while (!words.last()) {
            if (words.retrieve().equalsIgnoreCase(term)) {
                freq++;
            }
            words.findNext();
        }
        if (words.retrieve().equalsIgnoreCase(term)) {
            freq++;
        }
        return freq;
    }

    public static int get_doc_rank_score(Document d, String Query) {
        if (Query.length() == 0) return 0;
        String[] terms = Query.split(" ");
        int sum_freq = 0;
        for (int i = 0; i < terms.length; i++) {
            sum_freq += term_frequency_in_doc(d, terms[i].trim().toLowerCase());
        }
        return sum_freq;
    }

    public static void RankQuery(String Query) {
        LinkedList<Integer> A = new LinkedList<>();
        if (Query.length() == 0) return;
        String[] terms = Query.split(" ");
        boolean found = false;
        for (int i = 0; i < terms.length; i++) {
            found = inverted.Search_word_inverted(terms[i].trim().toLowerCase());
            if (found) {
                A = inverted.inverted_index.retrieve().IDs;
                Adding_in_1_List_sorted(A);
            }
        }
    }

    public static void Adding_in_1_List(LinkedList<Integer> A) {
        if (A.empty()) return;
        A.findFirst();
        while (!A.empty()) {
            boolean found = existsIn_result(all_doc_in_query, A.retrieve());
            if (!found) { // Not found in result
                all_doc_in_query.insert(A.retrieve());
            }
            if (!A.last()) {
                A.findNext();
            } else {
                break;
            }
        }
    }

    public static void Adding_in_1_List_sorted(LinkedList<Integer> A) {
        if (A.empty()) return;
        A.findFirst();
        while (!A.empty()) {
            boolean found = existsIn_result(all_doc_in_query, A.retrieve());
            if (!found) { // Not found in result
                insert_sorted_Id_list(A.retrieve());
            }
            if (!A.last()) {
                A.findNext();
            } else {
                break;
            }
        }
    }

    public static void insert_sorted_Id_list(Integer id) {
        if (all_doc_in_query.empty()) {
            all_doc_in_query.insert(id);
            return;
        }
        all_doc_in_query.findFirst();
        while (!all_doc_in_query.last()) {
            if (id > all_doc_in_query.retrieve()) {
                Integer id1 = all_doc_in_query.retrieve();
                all_doc_in_query.update(id);
                all_doc_in_query.insert(id1);
                return;
            } else {
                all_doc_in_query.findNext();
            }
        }
        if (id > all_doc_in_query.retrieve()) {
            Integer id1 = all_doc_in_query.retrieve();
            all_doc_in_query.update(id);
            all_doc_in_query.insert(id1);
            return;
        }
    }

    public static boolean existsIn_result(LinkedList<Integer> result, Integer id) {
        if (result.empty()) return false;
        result.findFirst();
        while (!result.last()) {
            if (result.retrieve().equals(id)) {
                return true;
            }
            result.findNext();
        }
        if (result.retrieve().equals(id)) {
            return true;
        }
        return false;
    }

}
