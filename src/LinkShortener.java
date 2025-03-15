import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LinkShortener {
    private final Map<String, String> urlToShort;
    private final Map<String, String> shortToUrl;

    public LinkShortener() {
        urlToShort = new HashMap<>();
        shortToUrl = new HashMap<>();
    }

    public String shortenUrl(String longUrl) {
        if (urlToShort.containsKey(longUrl)) {
            return urlToShort.get(longUrl);
        }

        String shortUrl = generateShortUrl(longUrl);
        urlToShort.put(longUrl, shortUrl);
        shortToUrl.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        return shortToUrl.getOrDefault(shortUrl, "Invalid short URL");
    }

    private String generateShortUrl(String longUrl) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(longUrl.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(Integer.toHexString(hash[i] & 0xFF));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash");
        }
    }

    public Map<String, String> getUrlToShort() {
        return urlToShort;
    }

    public Map<String, String> getShortToUrl() {
        return shortToUrl;
    }
}