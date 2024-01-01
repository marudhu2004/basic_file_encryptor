import java.io.*;

public class Encryptor {
    private String inFilePath;
    private String outFilePath;

    Encryptor(String inFilePath, String outFilePath){
        this.inFilePath = inFilePath;
        System.out.println("setting up!");
        this.outFilePath = outFilePath;
    }


    void encrypt(int shift, boolean decrypt){

        // Updating key to decrypt instead
        if (decrypt){
            shift *= -1;
        }
        System.out.println("using caeser cypher!");

        try (FileReader fileReader = new FileReader(inFilePath);
             FileWriter fileWriter = new FileWriter(outFilePath)) {

            int character;
            int diff;
            while ((character = fileReader.read()) != -1) {
                if(Character.isLetter(character)) {
                    if (Character.isUpperCase(character)){
                        diff = 'A';
                    } else
                    {
                        diff = 'a';
                    }

                    character =  Math.floorMod((character + shift - diff), 26) + diff;

                }

                fileWriter.write(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
