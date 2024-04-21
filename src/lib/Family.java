package lib;

public class Family {
    private String spouseName;
    private String spouseIdNumber;
    private String[] childNames;
    private String[] childIdNumbers;

    public Family() {
        this.childNames = new String[0];
        this.childIdNumbers = new String[0];
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        this.childNames = addToArray(this.childNames, childName);
        this.childIdNumbers = addToArray(this.childIdNumbers, childIdNumber);
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public int getNumberOfChildren() {
        return childIdNumbers.length;
    }

    private static String[] addToArray(String[] array, String value) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}