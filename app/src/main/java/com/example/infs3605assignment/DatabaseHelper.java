package com.example.infs3605assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.infs3605assignment.ui.knowledge.MCQuestion;
import com.example.infs3605assignment.ui.knowledge.ModuleCategories;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.example.infs3605assignment.ui.knowledge.ModuleCategories.getCategories;

// The following code is modified from: Programming Knowledge (2015)
// Android SQLite Database Tutorial 5
// http://programmingknowledgeblog.blogspot.com/2015/05/android-sqlite-database-tutorial-5.html

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "KFDAADJhgjaedfafvdsjgfhgcytcrgjghdfhfxchs342KFB.db";
    private SQLiteDatabase db;
    public static final String ACHIEVEMENTS = "ACHIEVEMENTS";
    public static final String QUIZ = "QUIZ";
    public static final String PROGRESS = "PROGRESS";
    public static final String NAME = "NAME";
    public static final String USERNAME = "USERNAME";
    public static final String FEEDBACK = "FEEDBACK";
    public static final String HIGHSCORE = "HIGHSCORE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
//        db.execSQL("CREATE TABLE LEARN (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER," +
//                "HEAD1 TEXT, CON1 TEXT, HEAD2 TEXT, CON2 TEXT, HEAD3 TEXT, CON3 TEXT, HEAD4 TEXT, CON4 TEXT, HEAD5 TEXT, CON5 TEXT, HEAD6 TEXT, CON6 TEXT, HEAD7 TEXT, CON7 TEXT)");
//        db.execSQL("CREATE TABLE LEARN (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER," +
//                "HEAD1 TEXT, CON1 TEXT, HEAD2 TEXT, CON2 TEXT, HEAD3 TEXT, CON3 TEXT, HEAD4, CON4)");
//        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4) VALUES (1, '1 - Heading 1','Content 1 - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n','Heading 2','Content 2 - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n','Heading 3','Content 3 - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n','Heading 4','Content 4 - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n')");
//        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4) VALUES " +
//                "(2, '2 - Heading 1','Content 1','Heading 2','Content 2','Heading 3','Content 3','Heading 4','Content 4')");
//        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4) VALUES " +
//                "(3, '3 - Heading 1','Content 1','Heading 2','Content 2','Heading 3','Content 3','Heading 4','Content 4')");
//        db.execSQL("INSERT INTO LEARN (LEVEL, HEAD1, CON1, HEAD2, CON2, HEAD3, CON3, HEAD4, CON4, HEAD5, CON5, HEAD6, CON6, HEAD7, CON7) VALUES (1,"What is a cyber attack","A cyber attack is an attack launched from one or more computers against another computer, multiple computers or networks. Cyber attacks can be broken down into two broad types: attacks where the goal is to disable the target computer, or attacks where the goal is to get access to the target computer's data and perhaps gain admin privileges on it. \n Cyber attacks will always be a problem due to the side effects of freedom and ease of communicating online. Therefore education on different types of attacks is important. ","Malware","Malware is a term used to describe malicious software that breaches a network through a vulnerability, typically when a user clicks a dangerous link or email attachment that then installs risky software. Once inside the system, malware can do the following: \n •	Blocks access to key components of the network (ransomware) \n •	Installs malware or additional harmful software \n •	Covertly obtains information by transmitting data from the hard drive (spyware) \n •	Disrupts certain components and renders the system inoperable ","Ransomware and Spyware ","Ransomware is a form of malware that encrypts a victim's files. The attacker then demands a ransom from the victim to restore access to the data upon payment. \n Spyware is a type of malware that aims to gather information about a person or organization, without their knowledge, and send such information to hack another entity without the consumer's consent.","Denial of Service","A denial-of-service attack floods systems, servers, or networks with traffic to exhaust resources and bandwidth. As a result, the system is unable to fulfill legitimate requests. Attackers can also use multiple compromised devices to launch this attack.","Trojan Horse","A Trojan horse or Trojan is a type of malware that is often disguised as legitimate software. Trojans can be employed by cyber-thieves and hackers trying to gain access to users' systems. Once activated, Trojans can enable cyber-criminals to spy on you, steal your sensitive data, and gain backdoor access to your system.","Man-In-The-Middle Attack","Man-in-the-middle (MitM) attacks, also known as eavesdropping attacks, occur when attackers insert themselves into a two-party transaction. Once the attackers interrupt the traffic, they can filter and steal data. \n Two common points of entry for MitM attacks: \n 1. On unsecure public Wi-Fi, attackers can insert themselves between a visitor’s device and the network. Without knowing, the visitor passes all information through the attacker. \n 2. Once malware has breached a device, an attacker can install software to process all of the victim’s information ","Prevention","•	Use a firewall for your Internet connection. \n •	Make backup copies of important business data and information. \n •	Secure your Wi-Fi networks \n •	Install, use and regularly update antivirus and antispyware software \n •	Include encryption, file permissions and access controls ")"
        db.execSQL("CREATE TABLE QUIZ (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER, MODULE TEXT, COMPLETED INTEGER, DAY TEXT, TIME INTEGER, PASS INTEGER, HIGHSCORE INTEGER)");
        addModules();
        db.execSQL("CREATE TABLE MCQ (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER, NUMBER INTEGER, QUESTION TEXT, OPT1 TEXT," +
                "OPT2 TEXT, OPT3 TEXT, OPT4 TEXT, CORRECT INTEGER, FEEDBACK TEXT, ANSWERED INTEGER)");
        fillQuestionsTable();

        db.execSQL("CREATE TABLE USER (ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT, FEEDBACK INTEGER)");
        db.execSQL("INSERT INTO USER ("+USERNAME+","+FEEDBACK+") VALUES " +
                "('username',0)");

        db.execSQL("CREATE TABLE ACHIEVEMENTS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, PROGRESS INTEGER)");
        db.execSQL("INSERT INTO "+ACHIEVEMENTS+" ("+NAME+", "+PROGRESS+") VALUES " +
                "('Champ', 0)");
        db.execSQL("INSERT INTO "+ACHIEVEMENTS+" ("+NAME+", "+PROGRESS+") VALUES " +
                "('Conqueror', 0)");
        db.execSQL("INSERT INTO "+ACHIEVEMENTS+" ("+NAME+", "+PROGRESS+") VALUES " +
                "('Master', 0)");
        db.execSQL("INSERT INTO "+ACHIEVEMENTS+" ("+NAME+", "+PROGRESS+") VALUES " +
                "('Scholar', 0)");
        db.execSQL("INSERT INTO "+ACHIEVEMENTS+" ("+NAME+", "+PROGRESS+") VALUES " +
                "('Weekend Winner', 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MCQ");
//        db.execSQL("DROP TABLE IF EXISTS LEARN");
        onCreate(db);
    }
    // Modified code stops here

//    public String getText(String column, int level) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor csr = db.rawQuery("SELECT "+column+" FROM LEARN WHERE LEVEL = "+level,null);
//        csr.moveToFirst();
//        String text = csr.getString(csr.getColumnIndex(column));
//        return text;
//    }

    private void fillQuestionsTable() {
        addQuestion(new MCQuestion(1,1,"Why are cyber vulnerabilities unlikely to ever go away?","They’re protected in a secret base on the moon","The government won’t allow people to fix them","Criminals need them to steal identities","They are side effects of the freedom and ease of communicating","We live in a ever-connected world through the internet. Making it easier for attackers to reach you",4));
        addQuestion(new MCQuestion(1,2,"Which of these groups exploits cyber vulnerabilities?","Criminals","Governments","Hackers","All of the above","All groups exploit cyber vulnerabilities.. Yes including government!",4));
        addQuestion(new MCQuestion(1,3,"What is Ransomware","Malware that is often disguised as legitimate software","A good type of malware","Software that encrypts a user's file","Software that secures user files","Ransomware is a form of malware that encrypts a victim's files. The attacker then demands a ransom from the victim to restore access to the data upon payment",3));
        addQuestion(new MCQuestion(1,4,"Harmful programs used to disrupt computer operation, gather sensitive information, or gain access to private computer systems are commonly referred to as:","Adware","Malware","Computer Viruses","Spyware","Malicious software that breaches a network through a vulnerability",2));
        addQuestion(new MCQuestion(1,5,"Malicious software collecting information about users without their knowledge/consent is known as:","Trojan","Virus","Ransomware","Spyware","Spyware is a type of malware that aims to gather information about a person or organization, without their knowledge",4));
        addQuestion(new MCQuestion(1,6,"Which of the following answers best describes a type of mobile software that while running in disguise of a legitimate program tries to harm user devices or personal data?","Trojan Horse","Malicious app","Phage Virus","Spyware","A Trojan horse or Trojan is a type of malware that is often disguised as legitimate software",1));
        addQuestion(new MCQuestion(1,7,"Any type of attack in which a third party manages to get in between the two parties communicating is called ____.","Stalking","Listening","Man-In-The-Middle","Crowding","MITM occur when attackers insert themselves into a two-party transaction",3));
        addQuestion(new MCQuestion(1,8,"Which of the following is the best answer for how to secure your device?","Secure Wi-fi","Firewall Installation","Continually update antiviral software","All of the above","All are great measures to secure your device",4));
        addQuestion(new MCQuestion(1,9,"You are sitting in the local café trying to send emails and catch up on tasks. To protect your communications over these public networks you should always do the following:","Find ther strongest wifi signal near you","Turn off your file sharing","Use a Virtual Private Network","Use Hotspot","A VPN allows a company to leverage Internet resources, enabling employees to easily collaborate from various locations, including home.",3));
        addQuestion(new MCQuestion(1,10,"Cyber security is the practice of ensuring the integrity, confidentiality, and availability of information. It helps prevent dangerous accidents like hard drive failures or power outages, and from attacks by adversaries. Three common controls used to protect the availability of information are","Redundancy, backups and access controls ","Encryption, file permissions and access controls","Access controls, logging and digital signatures","Hashes, logging and backups","To project your files these measures will block attackers from reaching it",2));
        addQuestion(new MCQuestion(2,1,"What is the goal of social engineering?","Sabotage a person’s social media","To catfish someone","To gain vital personal information ","To build trust","Social Engineering is the act of tricking someone into sharing confidential/sensitive information",3));
        addQuestion(new MCQuestion(2,2,"An email claiming that you have won the lottery, as long as you fill out the corresponding information, is an exmaple of what type of social enginnering attack?","Phishing","Baiting","Pretexting","Quid Pro Quo","Hacker is trying to bait you by saying you won the lottery. Don’t fall for it!",2));
        addQuestion(new MCQuestion(2,3,"What is the most common social engineering attack?","Phishing","Pretexting","Baiting","Tailgating","Phishing attacks are most common and accounts for 90% of databreaches!",1));
        addQuestion(new MCQuestion(2,4,"Social Engineering _____.","Relies on tricking and deceiving someone","Is illegal in the Us","Requires a computer and internet","Is rarely used today","Social engineering is less technical and focuses on human qualities such as trust",1));
        addQuestion(new MCQuestion(2,5,"Following an individual into a secure area without permission is known as _____.","Baiting","Shoulder surfing","Stalking","Tailgating","Tailgating plays on human’s helpfulness and enters an area without permission",4));
        addQuestion(new MCQuestion(2,6,"Which of the following practices best prevents Social Engineering","Firewalls","Blocking all social media","Don't reply to communications that require you to input sensitive data","Confirm with a friend","As long as sensitive information is not provided, you are less exposed to attacks",3));
        addQuestion(new MCQuestion(2,7,"The practice of using a telephone system to manipulate user into disclosing confidential information is called:","Whaling","Quid Pro Quo","Vishing","Pharming","Vishing is a similar attack with Phishing but requires the voice.",3));
        addQuestion(new MCQuestion(2,8,"An attacker impersonating as IT security sends you a message discussing you’re account as been hacked and needs information to help secure the account. Which social engineering principles apply to this attack scenario?","Authority, intimidation, Familiarity","Trust, Urgency, Authority ","Scarcity, Familiarity, Trust","Trust, Intimidation, Authority","Trust coming from IT security team, urgency as the account is hacked and authority coming from someone with security background",2));
        addQuestion(new MCQuestion(2,9,"Which of the following is NOT an example of a social engineering attack?","Spamming","Baiting","Pretexting","Quid Pro Quo","Spamming is not a social engineering attack",1));
        addQuestion(new MCQuestion(2,10,"Which of the following is the primary countermeasure to social engineering?","Awareness","Firewalls","Anti-virus","Not-replying","Awareness is the main protection to social engineering as social engineering plays on human behaviour",1));
        addQuestion(new MCQuestion(3,1,"How long should a password be?","5","8","10+","The length of your password does not matter","10+ is an ideal length for passwords.",3));
        addQuestion(new MCQuestion(3,2,"Which is the weakest password?","123456","Password","DogsAreGood1","Asdf","The weakest password is 123456.",1));
        addQuestion(new MCQuestion(3,3,"Which is the strongest password?","D0gs2","Dogs1","DoOGsAr3.,!@G00d","1Ki79yd3","1Ki79yd3, which is a series of random letters, numbers and special characters are the strongest password combiation after passphrases.",3));
        addQuestion(new MCQuestion(3,4,"What is the most secure type of password","Short, easy to remember password","Personal information that is relevant to the user","Series of random characters and numbers","Long list of random words","The most secure type of passwords are passphrases, which is a long list of random words.",4));
        addQuestion(new MCQuestion(3,5,"What is the strategy called when hackers try every combination of characters until they get your password?","Brute force","Dictionary","Phishing","Log Checking","Brute force is when hackers try every combination of characters until they match your password.",1));
        addQuestion(new MCQuestion(3,6,"What is a passphrase?","List of passwords","Series of random words put together","ID provided to employees","Series of random numbers and characters","Passphrases are a series of random words put together, and is confirmed to be the strongest type of passwords.",2));
        addQuestion(new MCQuestion(3,7,"What is two factor authentication?","Requiring two passwords","One person grants permission to another user","Confirming user access by using two different factors of verification","Requires supervision from a super account to allow access to accounts","Two factor authentication is when a user has to confirm access by using two different factors of verification. For example, when you log into your gmail account from another device, you are required to confirm your identity.",3));
        addQuestion(new MCQuestion(3,8,"What characters should you use in a password to make it strong","Letters and Numbers","Mixed case, upper and lower characters","Special characters","All of the above","By using a combination of all of the above, passwords would be harder to guess by infiltrators.",4));
        addQuestion(new MCQuestion(3,9,"How long would it take for a hacker to crack a 10 character password?","A few hours","Less than a week","A year","It depends","The time it would take for a hacker to crack your password, despite the length, is dependent on the character combination e.g upper and lower cases, special characters, passphrase usage, numbers etc.",4));
        addQuestion(new MCQuestion(3,10,"What is the best way to choose a new password?","Adding a number or special character at the front and end of your password","Something easy to remember such as your birthdate, first name, pet name etc","Passphrases, and modified passphrases  with complex patterns","Short and concise","Passphrases are a series of random words put together, and is confirmed to be the strongest type of passwords. They can also be modified, such as using capital letters, numbers around the words, so that it is more secure",3));
        addQuestion(new MCQuestion(4, 1, "Answer A", "A","B","C","D","",1));
        addQuestion(new MCQuestion(4, 2, "Answer B", "A","B","C","D","",2));
        addQuestion(new MCQuestion(4, 3, "Answer C", "A","B","C","D","",3));
        addQuestion(new MCQuestion(4, 4, "Answer D", "A","B","C","D","",4));
        addQuestion(new MCQuestion(4, 5, "Answer A", "A","B","C","D","",1));
        addQuestion(new MCQuestion(4, 6, "Answer B", "A","B","C","D","",2));
        addQuestion(new MCQuestion(4, 7, "Answer C", "A","B","C","D","",3));
        addQuestion(new MCQuestion(4, 8, "Answer D", "A","B","C","D","",4));
        addQuestion(new MCQuestion(4, 9, "Answer A", "A","B","C","D","",1));
        addQuestion(new MCQuestion(4, 10, "Answer B", "A","B","C","D","",2));
        addQuestion(new MCQuestion(5, 1, "This is a test question. The answer is A.", "A","B","C","D","This is the feedback text which provides an explanation.",1));
        addQuestion(new MCQuestion(5, 2, "This is a test question. The answer is B.", "A","B","C","D","This is the feedback text which provides an explanation.",2));
        addQuestion(new MCQuestion(5, 3, "This is a test question. The answer is C.", "A","B","C","D","This is the feedback text which provides an explanation.",3));
    }
    private void addQuestion(MCQuestion question) {
        ContentValues cv = new ContentValues();
        cv.put("LEVEL", question.getLevel());
        cv.put("NUMBER", question.getNumber());
        cv.put("QUESTION", question.getQuestion());
        cv.put("OPT1", question.getOption1());
        cv.put("OPT2", question.getOption2());
        cv.put("OPT3", question.getOption3());
        cv.put("OPT4", question.getOption4());
        cv.put("CORRECT", question.getAnswer());
        cv.put("FEEDBACK", question.getFeedback());
        cv.put("ANSWERED", 0);
        db.insert("MCQ", null, cv);
    }
    private void addModules() {
        ArrayList<ModuleCategories> categories = getCategories();
        for (int i = 0; i < categories.size(); i++) {
            ContentValues cv = new ContentValues();
            cv.put("LEVEL", categories.get(i).getLevel());
            cv.put("MODULE", categories.get(i).getCategoryName());
            cv.put("COMPLETED", 0);
            cv.put("HIGHSCORE", 0);
            db.insert("QUIZ", null, cv);
        }
    }
    public void setQuiz(String column, int level)  {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE QUIZ SET " +column+ " = 1 WHERE LEVEL = "+level);
        db.close();
    }

    public void setUsername(String username)  {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE USER SET USERNAME = "+"'"+username+"'");
        db.close();
    }

    public boolean checkUsername()  {
        SQLiteDatabase db = this.getWritableDatabase();
        String username;
        Cursor csr = db.rawQuery("SELECT USERNAME FROM USER", null);
        csr.moveToFirst();
        username = csr.getString(csr.getColumnIndex("USERNAME"));
        if (username.equals("username")) {
            return false;
        } else {
            return  true;
        }
    }

    public boolean checkQuiz(String column, int level)  {
        SQLiteDatabase db = this.getWritableDatabase();
        int completed;
        Cursor csr = db.rawQuery("SELECT " +column+ " FROM QUIZ WHERE LEVEL = "+level, null);
        csr.moveToFirst();
        completed = csr.getInt(csr.getColumnIndex(column));
        if (completed == 0) {
            return false;
        } else {
            return  true;
        }
    }

    public void setProgress(String name, int progress){
        SQLiteDatabase db = this.getWritableDatabase();
        int currentProgress;
        Cursor csr = db.rawQuery("SELECT PROGRESS FROM ACHIEVEMENTS WHERE NAME = "+"'"+name+"'", null);
        csr.moveToFirst();
        currentProgress = csr.getInt(csr.getColumnIndex("PROGRESS"));
        progress = currentProgress + progress;
        db.execSQL("UPDATE ACHIEVEMENTS SET PROGRESS = " + progress+ " WHERE NAME = " + "'"+name+"'");
        db.close();
    }

    public void setDay(String day, int level){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE QUIZ SET DAY = " +"'"+day+"'"+ " WHERE LEVEL = " + level);
        db.close();
    }

    public void setHighScore(int score, int level){
        SQLiteDatabase db = this.getWritableDatabase();
        int highScore;
        Cursor csr = db.rawQuery("SELECT HIGHSCORE FROM QUIZ WHERE LEVEL = "+level, null);
        csr.moveToFirst();
        highScore = csr.getInt(csr.getColumnIndex("HIGHSCORE"));
        if (score > highScore) {
            db.execSQL("UPDATE QUIZ SET HIGHSCORE = "+score+ " WHERE LEVEL = "+level);
        }
    }

    public boolean checkDay(String day){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean dayBoolean = false;
            for (int level = 1; level < 5; level++){
                Cursor csr = db.rawQuery("SELECT DAY FROM QUIZ WHERE LEVEL = " + level,null);
                csr.moveToFirst();
                String savedDay = csr.getString(csr.getColumnIndex("DAY"));
            if(savedDay != null && savedDay.equals(day)){
                dayBoolean = true;
                break;
            }
        }
        return dayBoolean;
    }

    public boolean checkFeedback(){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean feedback = false;
        for (int level = 1; level < 5; level++){
            Cursor csr = db.rawQuery("SELECT HIGHSCORE FROM QUIZ WHERE LEVEL = " + level,null);
            csr.moveToFirst();
            int highscore = csr.getInt(csr.getColumnIndex("HIGHSCORE"));
            csr = db.rawQuery("SELECT FEEDBACK FROM USER",null);
            csr.moveToFirst();
            int complete = csr.getInt(csr.getColumnIndex("FEEDBACK"));
            int count = 0;
            if(highscore >= 5 && complete == 0){
                count ++;
                if(count == 1){
                    feedback = true;
                    break;
                }
            }
        }
        return feedback;
    }

    public void setFeedback(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE USER SET FEEDBACK = 1");
        db.close();
    }
    public long getTime(int level){
        SQLiteDatabase db = this.getWritableDatabase();
        long time;
        Cursor csr = db.rawQuery("SELECT TIME FROM QUIZ WHERE LEVEL = " + level, null);
        csr.moveToFirst();
        time = csr.getLong(csr.getColumnIndex("TIME"));
        return time;
    }

    public String getUsername(){
        SQLiteDatabase db = this.getWritableDatabase();
        String username;
        Cursor csr = db.rawQuery("SELECT USERNAME FROM USER", null);
        csr.moveToFirst();
        username = csr.getString(csr.getColumnIndex("USERNAME"));
        return username;
    }

    public void setTime(long time, int level) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE QUIZ SET TIME = " + time + " WHERE LEVEL = " + level);
        db.close();
    }

    public void setAnswered(int level, int position)  {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE MCQ SET ANSWERED = 1 WHERE LEVEL = "+level+" AND NUMBER = "+position);
        db.close();
    }

//    LEVEL, NUMBER, QUESTION, OPT1, OPT2, OPT3, OPT4, CORRECT, FEEDBACK, ANSWERED
//    public List<MCQuestion> getAllQuestions() {
//        List<MCQuestion> questionList = new ArrayList<>();
//        db = getReadableDatabase();
//        Cursor c = db.rawQuery("SELECT * FROM MCQ", null);
//        if (c.moveToFirst()) {
//            do {
//                MCQuestion question = new MCQuestion();
//                question.setLevel(c.getInt(c.getColumnIndex("LEVEL")));
//                question.setNumber(c.getInt(c.getColumnIndex("NUMBER")));
//                question.setQuestion(c.getString(c.getColumnIndex("QUESTION")));
//                question.setOption1(c.getString(c.getColumnIndex("OPT1")));
//                question.setOption2(c.getString(c.getColumnIndex("OPT2")));
//                question.setOption3(c.getString(c.getColumnIndex("OPT3")));
//                question.setOption4(c.getString(c.getColumnIndex("OPT4")));
//                question.setAnswer(c.getInt(c.getColumnIndex("CORRECT")));
//                question.setFeedback(c.getString(c.getColumnIndex("FEEDBACK")));
//                questionList.add(question);
//            } while (c.moveToNext());
//        }
//        c.close();
//        return questionList;
//    }

    public List<MCQuestion> getQuestions(int level) {
        List<MCQuestion> questionList = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM MCQ WHERE LEVEL = "+level, null);
        if (c.moveToFirst()) {
            do {
                MCQuestion question = new MCQuestion();
                question.setLevel(c.getInt(c.getColumnIndex("LEVEL")));
                question.setNumber(c.getInt(c.getColumnIndex("NUMBER")));
                question.setQuestion(c.getString(c.getColumnIndex("QUESTION")));
                question.setOption1(c.getString(c.getColumnIndex("OPT1")));
                question.setOption2(c.getString(c.getColumnIndex("OPT2")));
                question.setOption3(c.getString(c.getColumnIndex("OPT3")));
                question.setOption4(c.getString(c.getColumnIndex("OPT4")));
                question.setAnswer(c.getInt(c.getColumnIndex("CORRECT")));
                question.setFeedback(c.getString(c.getColumnIndex("FEEDBACK")));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}