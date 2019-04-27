
public class Output {
      
    String message; //stores passed in message
    String messageArranged = ""; //stores passed in message organised from words of least value to words of greatest value
    
    public void Arrange(String msg) {
        
        message = msg; //passed in message
        int track = 0; //used to limit certain words to be processed depending on word length see ***see getShortest()***
        int getWordsWithLength = 0;
        if (!(msg.substring(msg.length() - 1, msg.length()).equals(" "))) //a word is recognised if there is a space to the right of it. 
        {
            message = message + " "; //Add space to the end of passed in message if there isn't one.
        }
        
        while (getShortest(track) != 0) //returns 0 if there are no word greater than the value of track i.e. all words have been processed
        {
            getWordsWithLength = getShortest(track); //returns a specific word length 
        
            appendToMessageArranged(getWordsWithLength); //finds all the words in the message with that word length and appends each of them to messageArranged variable

            track = getWordsWithLength; //track now set to that word length so in the next iteration only the words greater than the ones previously checked are processed
        }
  
        System.out.println(messageArranged);
    }
    
    public int getShortest(int track)
    {
        int shortestLength = 0; //stores the length of the word with the shortest length (within specified range) 
        String shortestWord = ""; //stores word with the shortest length (within specified range) 
        
        String aWord = ""; //stores a single word within the message at a specific stage of the loop
        
        for (int x = 0; x < message.length(); x++) //loop through each character of the message
        {
            if (message.substring(x, x + 1).equals(" ")) // if the current character is a space, a word has been formed in 'aWord' variable
            {
                if (aWord.length() > track) //ensure the lengths of the words to be processed are greater than a set value e.g. If set to 3, will only deal with words with lengths greater than 3
                {
                    if (shortestWord.equals("")) //appends first word 
                    {
                        shortestLength = aWord.length();
                        shortestWord= aWord;
                    }

                    if (aWord.length() < shortestWord.length()) //if the length of the current word is less than the word already in the shortestWord variable
                    {        
                        shortestLength = aWord.length();
                        shortestWord= aWord;
                    }
                }       
                aWord = ""; //reset aWord variable to get the subsequent word
            }
            else // if the current character is not space, append that character to the 'aWord' variable
            {
                aWord = aWord + message.substring(x, x + 1);
            }        
        }
        
        return shortestLength; 
        
    }
    
    public void appendToMessageArranged(int length)
    {
        String aWord = "";
                
        for (int x = 0; x < message.length(); x++)
        {
            if (message.substring(x, x + 1).equals(" "))
            {
                if (aWord.length() == length)
                {
                    messageArranged = messageArranged + aWord + " ";
                }
                
                aWord = "";
            }
            else
            {
                aWord = aWord + message.substring(x, x + 1);
            }
        }
    }
}
