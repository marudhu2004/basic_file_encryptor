public class Main {
    public static void main(String[] args){
        Encryptor encryptor = new Encryptor("enc.txt", "dec.txt");
        encryptor.encrypt(10, true);
    }

}
