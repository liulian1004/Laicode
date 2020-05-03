// T: 2^n * n(DFS) +  n^2(print ifblock)
    //S: O(n)(DFS)
    // DFS {} permutation + print ifblocks
    private void ifBlock(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, 0,0, sb, n);
        for(String i: result) {
            printResult(i);
        }
    }

    private void helper(List<String> result, int left, int right, StringBuilder sb, int n) {
        if(left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        if(left < n ){
           sb.append("{");
           helper(result, left + 1, right, sb, n);
           sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left) {
            sb.append("}");
            helper(result, left , right +1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    // initialization: space = 0
    // { ==> print space--> print if{-->space + 2
    // } ==> space - 2--> print space --> print {
    private void printResult(String result) {
        int space = 0;
       for(Character i: result.toCharArray()){
            if(i == '{') {
                for(int j = 0; j < space; j++) {
                    System.out.print(" ");
                }
                System.out.println("if{");
                    space += 2;
                } else {
                    space -= 2;
                for(int j = 0; j < space; j++) {
                    System.out.print(" ");
                }
                    System.out.println("}");
                }
        }
    }
