public class Codec {
    HashMap <String,String> encode_map = new HashMap<>();
    HashMap <String,String> decode_map = new HashMap<>();
    String base_url = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!encode_map.containsKey(longUrl)){
            String encoded_url = String.valueOf(encode_map.size());
            String short_url = base_url + encoded_url;
            encode_map.put(longUrl,short_url);
            decode_map.put(short_url,longUrl);
        }
        return encode_map.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode_map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));