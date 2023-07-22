import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileIO
{
    public void writeData(Map<String, AddressBook> addressBook)
    {
        File file = new File("C:\\Users\\User\\IdeaProjects\\AddressBookUC13\\src\\AddressBook.txt");
        BufferedWriter bw;
        try
        {
            bw = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, AddressBook> entry : addressBook.entrySet())
            {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Map<String, String> readData()
    {
        Map<String, String> mapFileContents = new HashMap<>();
        BufferedReader br = null;
        try
        {
            File file = new File("Address Book.txt");

            br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(":");
                String bookName = parts[0].trim();
                String name = parts[1].trim();
                mapFileContents.put(bookName, name);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                } catch (Exception e)
                {
                    System.out.println();
                }
            }
        }
        return mapFileContents;
    }
}