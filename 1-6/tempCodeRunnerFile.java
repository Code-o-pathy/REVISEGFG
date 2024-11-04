        if(l>=r) return true;
        if (s.charAt(l) == s.charAt(r)) {

            return V10(s, l++, r--);
        }
        return false;