package core.basesyntax;

public class ContentConverter {
    public static final String SUPPLY_VAR = "supply";
    public static final String BUY_VAR = "buy";
    public static final String RESULT_VAR = "result";
    public static final String SPLIT_VAR = ",";
    public static final byte FIRST_ARRAY_VAR = 0;
    public static final byte SECOND_ARRAY_VAR = 1;

    public String getHandledFileContent(String content) {
        int buySum = 0;
        int supplySum = 0;
        String[] contentArray = content.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String line : contentArray) {
            String[] valuesArray = line.split(SPLIT_VAR);
            if (valuesArray[FIRST_ARRAY_VAR].equals(BUY_VAR)) {
                buySum += Integer.parseInt(valuesArray[SECOND_ARRAY_VAR]);
            }
            if (valuesArray[FIRST_ARRAY_VAR].equals(SUPPLY_VAR)) {
                supplySum += Integer.parseInt(valuesArray[SECOND_ARRAY_VAR]);
            }
        }
        builder.append(SUPPLY_VAR)
                .append(SPLIT_VAR)
                .append(supplySum)
                .append(System.lineSeparator())
                .append(BUY_VAR)
                .append(SPLIT_VAR)
                .append(buySum)
                .append(System.lineSeparator())
                .append(RESULT_VAR)
                .append(SPLIT_VAR)
                .append(supplySum - buySum);
        return builder.toString();
    }
}
