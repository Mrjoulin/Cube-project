package print;

public class RefactorScrambl {
    public static String Scrambl(StringBuilder scrambl) {
        StringBuilder newScrambl = new StringBuilder();
        char lastLetter = ' ';
        int counter = 0;
        int hatch = 0;
        int dlaseba = 0;
        for (int i = 0; i < scrambl.length(); i++) {
            if (scrambl.charAt(i) != ' ') {
                if (lastLetter == scrambl.charAt(i)) {
                    if (i > 1) {
                        if (((int) scrambl.charAt(i + 1) == 39 && scrambl.charAt(i - 2) == lastLetter) || (scrambl.charAt(i + 1) == ' ' && (int) scrambl.charAt(i - 2) == 39)) {
                            if ((int) scrambl.charAt(i + 1) == 39 && scrambl.charAt(i - 2) == lastLetter) {
                                counter--;
                                newScrambl.deleteCharAt(counter);
                                counter--;
                                newScrambl.deleteCharAt(counter);
                                counter--;
                                newScrambl.deleteCharAt(counter);
                                i++;
                                continue;
                            } else {
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                continue;
                            }
                        } else {
                            newScrambl.append(scrambl.charAt(i));
                            counter++;
                            continue;
                        }
                    }
                }
                if ((int) scrambl.charAt(i) != 39) {
                    dlaseba++;
                    lastLetter = scrambl.charAt(i);
                    newScrambl.append(scrambl.charAt(i));
                }
                if ((int) scrambl.charAt(i) == 39) {
                    newScrambl.append(scrambl.charAt(i));
                }
            } else {
                newScrambl.append(scrambl.charAt(i));
            }
            counter++;
        }
        System.out.println(dlaseba);
        lastLetter = ' ';
        counter = 0;
        for (int i = 0; i < newScrambl.length(); i++) {
            if (newScrambl.charAt(i) != ' ') {
                if (newScrambl.charAt(i) != lastLetter){
                    lastLetter = newScrambl.charAt(i);
                    counter = 1;
                }else {
                    counter++;
                }
                if (counter == 4){
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    counter = 0;
                }
            }
        }
        counter = 0;
        lastLetter = ' ';
        for (int i = 0; i < newScrambl.length(); i++) {
            if (newScrambl.charAt(i) != ' ') {
                if (newScrambl.charAt(i) != lastLetter) {
                    lastLetter = newScrambl.charAt(i);
                    hatch = 0;
                    counter = 1;
                } else {
                    counter++;
                }
                if (counter == 3) {
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.insert(i,"'");
                    i++;
                    newScrambl.deleteCharAt(i);
                    counter = 0;
                }
            }
        }
        counter = 0;
        lastLetter = ' ';
        for (int i = 0; i < newScrambl.length(); i++) {
            if ((int)newScrambl.charAt(i) != 39){
                if (newScrambl.charAt(i) != ' ') {
                    if (newScrambl.charAt(i) != lastLetter) {
                        lastLetter = newScrambl.charAt(i);
                        hatch = 0;
                        counter = 1;
                    }else {
                        counter++;
                    }
                    if (counter == 2) {
                        if (hatch == 0){
                            newScrambl.deleteCharAt(i);
                            i--;
                            newScrambl.insert(i, "2");
                            i++;
                            newScrambl.deleteCharAt(i);
                            counter = 0;
                        }
                        if (hatch == 1){
                            newScrambl.deleteCharAt(i + 1);
                            newScrambl.deleteCharAt(i);
                            newScrambl.deleteCharAt(i - 1);
                            newScrambl.insert(i - 2, "2");
                            newScrambl.deleteCharAt(i - 1);
                            counter = 0;
                        }
                    }
                }
            }else {
                hatch++;
            }
        }
        return newScrambl.toString();
    }
}
