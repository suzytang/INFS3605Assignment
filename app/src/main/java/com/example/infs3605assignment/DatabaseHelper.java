package com.example.infs3605assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.infs3605assignment.ui.knowledge.MCQuestion;

import java.util.ArrayList;
import java.util.List;

// The following code is modified from: Programming Knowledge (2015)
// Android SQLite Database Tutorial 5
// http://programmingknowledgeblog.blogspot.com/2015/05/android-sqlite-database-tutorial-5.html

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "uhifJKSDFBKSDJB4aifa235234b.db";
    private SQLiteDatabase db;

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
        db.execSQL("CREATE TABLE MCQ (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER, NUMBER INTEGER, QUESTION TEXT, OPT1 TEXT," +
                "OPT2 TEXT, OPT3 TEXT, OPT4 TEXT, CORRECT INTEGER, FEEDBACK TEXT, ANSWERED INTEGER)");
        fillQuestionsTable();


        db.execSQL("CREATE TABLE ACHIEVEMENTS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, PROGRESS INTEGER)");
        db.execSQL("INSERT INTO ACHIEVEMENTS (NAME, PROGRESS) VALUES " +
                "(1, 'Champ', 0)");

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
        addQuestion(new MCQuestion(1, 1, "A is correct", "A", "B", "C", "D", "feedback", 1));
        addQuestion(new MCQuestion(1, 2, "B is correct", "A", "B", "C", "D", "feedback", 2));
        addQuestion(new MCQuestion(1, 3, "C is correct", "A", "B", "C", "D", "feedback", 3));
        addQuestion(new MCQuestion(1, 4, "D is correct", "A", "B", "C", "D", "feedback", 4));
        addQuestion(new MCQuestion(2, 1, "A is correct", "A", "B", "C", "D", "feedback", 1));
        addQuestion(new MCQuestion(2, 2, "B is correct", "A", "B", "C", "D", "feedback", 2));
        addQuestion(new MCQuestion(3, 1, "C is correct", "A", "B", "C", "D", "feedback", 3));
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