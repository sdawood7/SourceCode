
public class BaseConverter {

  private String original;
  private int nInt, baseFrom, baseTo;
  public final char[] digits =
  {'0','1','2','3','4','5','6','7',
  '8','9','A','B','C','D','E','F'};

  public void setOriginal(String original) {
    this.original = original;
  }

  public String getOriginal() {
    return original;
  }

  public void setnInt(int nInt) {
    this.nInt = nInt;
  }

  public int getnInt() {
    return nInt;
  }

  public void setBaseTo(int baseTo) {
    this.baseTo = baseTo;
  }

  public int getBaseTo() {
    return baseTo;
  }

  public void setBaseFrom(int baseFrom) {
    this.baseFrom = baseFrom;
  }

  public int getBaseFrom() {
    return baseFrom;
  }

  private void fromBase10Helper(int n, int base) {
    if(n == 0)
      return;
    fromBase10Helper(n/base, base);
    System.out.printf("%c", digits[n%base]);
  }

  public void fromBase10(int n, int base) {
    if(n == 0)
      System.out.printf("0");
    else
      fromBase10Helper(n, base);
    System.out.println();
  }

  public void panic() {
    System.out.printf("ERROR: Failure to convert.\n");
    System.exit(0);
  }

  private int toDigit(char c) {
    int val = Character.valueOf(c);
    if(val >= 'a' && val <= 'z')
      return (val - 'a') + 10;
    else if(val >= 'A' && val <= 'Z')
      return (val - 'A') + 10;
    else if(val >= '0' && val <= '9')
      return val - '0';
    else
      panic();
    return 0;
  }

  public int toBase10(String original, int baseFrom) {
    int i, len = original.length(), result = 0;
    char c;
    for(i = 0; i < len; i++) {
      c = original.charAt(i);
      result *= baseFrom;
      result += toDigit(c);
    }
    return result;
  }
}
