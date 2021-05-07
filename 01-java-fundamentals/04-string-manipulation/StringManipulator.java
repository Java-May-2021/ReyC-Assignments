public class StringManipulator {
    public String trimAndConcat(String stringA, String stringB) {
        return stringA.trim().concat(stringB.trim());
    }
    public Integer getIndexOrNull(String stringA, char charB) {
        if (stringA.indexOf(charB) == -1) {
            return null;
        } else {
            return stringA.indexOf(charB);
        }
    }

    public Integer getIndexOrNull(String stringA, String stringB) {
        if (stringA.indexOf(stringB) == -1) {
            return null;
        } else {
            return stringA.indexOf(stringB);
        }
    }

    public String concatSubString(String stringA, int startIndex, int endIndex, String stringB) {
        return stringA.substring(startIndex, endIndex).concat(stringB);
    }
}