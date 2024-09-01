/**
 * https://leetcode.com/problems/design-authentication-manager/description/
 */
class AuthenticationManager {
    Map<String, Integer> token; // token ID , expiryTime
    int ttl; // time to live

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        token = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        token.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if (!token.containsKey(tokenId)) return;

        int currTTL = token.get(tokenId);
        if (currTTL > currentTime) {
            generate(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;

        for (String id : token.keySet()) {
            if (currentTime < token.get(id)) count++;
        }

        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */