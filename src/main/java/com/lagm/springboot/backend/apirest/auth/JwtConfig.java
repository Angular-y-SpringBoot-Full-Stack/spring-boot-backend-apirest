package com.lagm.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.importante.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN PRIVATE KEY-----\n"
			+ "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/7KfNvnvbH9eK\n"
			+ "QBH0VIrPgeU35ZDG9qtw0qY9bIt4Vrol0aoDXsGKC1rAR30P+EZ64wvYbjVNuvfQ\n"
			+ "6wIMHKIeZ86srT44TKTWddoJVLWvCmA80Ja1fPCFU85J9sn5EgsaSLco+Dww7is2\n"
			+ "bznS5sCxBGgMBQdMzjmEWgZvrkWj8Aw/94ZWmzoCiSCuIO0zs5Bi9eNV1KQqAbkK\n"
			+ "ghmM79KzWRrn3RYAbJKIheLlTH9bkttfo7t+4b4wp+tOMDK3W4Zna/5k7pBtYkVe\n"
			+ "/SCkuVwv/R08mNhTM8oLMIjeuMdcjzhpaGQllUf2Z3OcxYYGCS4uYD99XAdRTPwY\n"
			+ "YUHN9O3tAgMBAAECggEAILRjaOI5iV7M9CxUUuoYKGGmbYbDS8BLeSOQO/3T62r9\n"
			+ "+AVZHw9l1A/4xDS6aT8BxZ2MjnJDR45hfdqaI/W6I4vFcnPoGyBmY3w8LiRe/Ge8\n"
			+ "fAiAcgdLFjEwgTaadsS+GxnCimr4mM7xEqrT8+4p7lBFqayusIYg036iw6OzDssE\n"
			+ "wWOzpFcXi2Bm6kChsMThKDluZQ71hN7IyT3SmghZFN4rpvLLT1sLSjf72KQU/1Gk\n"
			+ "8RmPdhG2cPW8dsWZOsUcX0ICwLq7l9QWDy5CGhfOiOO5EguBCnS64rLGjrKLBM47\n"
			+ "xLxOYuyb/14DKc+EEhBk8/+jk071D2eG5n47GzCvAQKBgQDaAFfQDZ9WY+x+LcTC\n"
			+ "UKXiBukeLsQgeLO89dguKiPC8qwe8wRhlPnIu6c0IcVbwMkYexbTxo4UeRl6u+mY\n"
			+ "fAbcJD1InfH/XlbDPqBsNF+5hBj5h5eyRjlm8Q/55GDGuYikozkgpz4Cn2k9K95A\n"
			+ "7N3m50vb+iuurjTFej9JdhzG7QKBgQDhYLVs32xXXuje19J+DeyB241ZXMnLc6Jo\n"
			+ "NWgvaeeJvSyV4H3yMyznWojMstR7/isO8MHGp/kPGK72tL1DnSomnifZniwYm5DD\n"
			+ "XYUAw9C/NkW2eNuws8ibfqFJ/z3EiSmgApXdZ91m17BnsgqIv5j/65vCeoGGnk04\n"
			+ "zPkf3sTjAQKBgQCmha6OKWm2JvwGYlWzDMG5xweZW6XLHAhH5g8tLFlG1/HsbjvB\n"
			+ "gnfPArC1HLrR3JB/175XJItxThPNce784Hio/jGl36h0Jg7mc1c9cEBSyHn/Wbjh\n"
			+ "n8zHOoq2muHlyuF6yYegzr+KZ1SPOow6UfUrJTEIJq/pbf63fisLpWJT/QKBgQDA\n"
			+ "tFPr901Hl1s9zwOnzHgAwJ0nX3Mbho/C0od2ovLajunkbMLDqIYoevylKfMM4dIn\n"
			+ "QCwvk8gc5FoVj4yUl3lG88vXAqtpjvpEUV47vTJrjBgnYUdW2yIX8joubxN9TFpO\n"
			+ "+mbxnLFuEdY/k7f2HPzRNb9ElkLRu+EDRB9u5KcsAQKBgGLIALgs2os07P/GDRsV\n"
			+ "dVObYOYa+dVjtLLKNGQjU9owgA8Xd7cgmA38B5RzypBapx/1mHftwow69vwe6U0c\n"
			+ "hjN9T2bHrKDumpBUvKKaF0wzUnBFBAUZ9XMkKbvV6/vg9lIQRJJn8I/LfVs9O63d\n"
			+ "HRJqizvDNP7nWPD/ya/SZH9+\n"
			+ "-----END PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv+ynzb572x/XikAR9FSK\n"
			+ "z4HlN+WQxvarcNKmPWyLeFa6JdGqA17BigtawEd9D/hGeuML2G41Tbr30OsCDByi\n"
			+ "HmfOrK0+OEyk1nXaCVS1rwpgPNCWtXzwhVPOSfbJ+RILGki3KPg8MO4rNm850ubA\n"
			+ "sQRoDAUHTM45hFoGb65Fo/AMP/eGVps6AokgriDtM7OQYvXjVdSkKgG5CoIZjO/S\n"
			+ "s1ka590WAGySiIXi5Ux/W5LbX6O7fuG+MKfrTjAyt1uGZ2v+ZO6QbWJFXv0gpLlc\n"
			+ "L/0dPJjYUzPKCzCI3rjHXI84aWhkJZVH9mdznMWGBgkuLmA/fVwHUUz8GGFBzfTt\n"
			+ "7QIDAQAB\n"
			+ "-----END PUBLIC KEY-----";
}
