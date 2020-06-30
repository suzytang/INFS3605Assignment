package com.example.infs3605assignment.ui.knowledge;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class ModuleData {
    private int level;
    private String head1;
    private String con1;
    private String head2;
    private String con2;
    private String head3;
    private String con3;
    private String head4;
    private String con4;
    private String head5;
    private String con5;
    private String head6;
    private String con6;
    private String head7;
    private String con7;

    public ModuleData() {
    }
    public ModuleData(int level, String head1, String con1, String head2, String con2, String head3, String con3, String head4, String con4, String head5, String con5, String head6, String con6, String head7, String con7) {
        this.level = level;
        this.head1 = head1;
        this.con1 = con1;
        this.head2 = head2;
        this.con2 = con2;
        this.head3 = head3;
        this.con3 = con3;
        this.head4 = head4;
        this.con4 = con4;
        this.head5 = head5;
        this.con5 = con5;
        this.head6 = head6;
        this.con6 = con6;
        this.head7 = head7;
        this.con7 = con7;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getHead1() {
        return head1;
    }

    public void setHead1(String head1) {
        this.head1 = head1;
    }

    public String getCon1() {
        return con1;
    }

    public void setCon1(String con1) {
        this.con1 = con1;
    }

    public String getHead2() {
        return head2;
    }

    public void setHead2(String head2) {
        this.head2 = head2;
    }

    public String getCon2() {
        return con2;
    }

    public void setCon2(String con2) {
        this.con2 = con2;
    }

    public String getHead3() {
        return head3;
    }

    public void setHead3(String head3) {
        this.head3 = head3;
    }

    public String getCon3() {
        return con3;
    }

    public void setCon3(String con3) {
        this.con3 = con3;
    }

    public String getHead4() {
        return head4;
    }

    public void setHead4(String head4) {
        this.head4 = head4;
    }

    public String getCon4() {
        return con4;
    }

    public void setCon4(String con4) {
        this.con4 = con4;
    }

    public String getHead5() {
        return head5;
    }

    public void setHead5(String head5) {
        this.head5 = head5;
    }

    public String getCon5() {
        return con5;
    }

    public void setCon5(String con5) {
        this.con5 = con5;
    }

    public String getHead6() {
        return head6;
    }

    public void setHead6(String head6) {
        this.head6 = head6;
    }

    public String getCon6() {
        return con6;
    }

    public void setCon6(String con6) {
        this.con6 = con6;
    }

    public String getHead7() {
        return head7;
    }

    public void setHead7(String head7) {
        this.head7 = head7;
    }

    public String getCon7() {
        return con7;
    }

    public void setCon7(String con7) {
        this.con7 = con7;
    }

    public static ArrayList<ModuleData> getData() {
        ArrayList<ModuleData> data = new ArrayList<>();
        data.add(new ModuleData(1,"What is a cyber attack","A cyber attack is an attack launched from one or more computers against another computer, multiple computers or networks. Cyber attacks can be broken down into two broad types: attacks where the goal is to disable the target computer, or attacks where the goal is to get access to the target computer's data and perhaps gain admin privileges on it. \nCyber attacks will always be a problem due to the side effects of freedom and ease of communicating online. Therefore education on different types of attacks is important. ","Malware","Malware is a term used to describe malicious software that breaches a network through a vulnerability, typically when a user clicks a dangerous link or email attachment that then installs risky software. Once inside the system, malware can do the following: \n •	Blocks access to key components of the network (ransomware) \n •	Installs malware or additional harmful software \n •	Covertly obtains information by transmitting data from the hard drive (spyware) \n •	Disrupts certain components and renders the system inoperable ","Ransomware and Spyware ","Ransomware is a form of malware that encrypts a victim's files. The attacker then demands a ransom from the victim to restore access to the data upon payment. \n Spyware is a type of malware that aims to gather information about a person or organization, without their knowledge, and send such information to hack another entity without the consumer's consent.","Denial of Service","A denial-of-service attack floods systems, servers, or networks with traffic to exhaust resources and bandwidth. As a result, the system is unable to fulfill legitimate requests. Attackers can also use multiple compromised devices to launch this attack.","Trojan Horse","A Trojan horse or Trojan is a type of malware that is often disguised as legitimate software. Trojans can be employed by cyber-thieves and hackers trying to gain access to users' systems. Once activated, Trojans can enable cyber-criminals to spy on you, steal your sensitive data, and gain backdoor access to your system.","Man-In-The-Middle Attack","Man-in-the-middle (MitM) attacks, also known as eavesdropping attacks, occur when attackers insert themselves into a two-party transaction. Once the attackers interrupt the traffic, they can filter and steal data. \nTwo common points of entry for MitM attacks: \n 1. On unsecure public Wi-Fi, attackers can insert themselves between a visitor’s device and the network. Without knowing, the visitor passes all information through the attacker. \n 2. Once malware has breached a device, an attacker can install software to process all of the victim’s information ","Prevention"," •	Use a firewall for your Internet connection. \n •	Make backup copies of important business data and information. \n •	Secure your Wi-Fi networks \n •	Install, use and regularly update antivirus and antispyware software \n •	Include encryption, file permissions and access controls"));
        data.add(new ModuleData(2,"What is Social Engineering","Social Engineering is the act of tricking someone into sharing confidential/sensitive information by taking advantage of the victims’ natural tendencies and assumptions \n Social engineering usually takes two forms, one is a passive form where the attacker usually never sees or talks to the victim and the other is a more active approach to gathering or tricking individuals out of information. ","Phishing","Phishing attacks are the most common type of attacks leveraging social engineering techniques. Attackers use emails, social media and instant messaging, and SMS to trick victims into providing sensitive information or visiting malicious URL in the attempt to compromise their systems. \n For example, a notice that your email password will expire, with a link to change the password that leads to a malicious website. ","Pretexting","The cybercriminal creates a false persona to obtain information or influence behaviour. Pretexting requires the attacker to build trust with no target \n In contrast to phishing attacks which mainly exploit fear and panic, pretexting relies on trust. \n For example, an attacker can impersonate an external IT services operator to ask internal staff for information that could allow accessing system within the organization. ","Baiting and Quid Pro Quo Attacks ","Baiting exploits the human’s curiosity. Baiting’s main characteristic is the promise of a good that hackers use to deceive the victims. \n For example, attackers use a malicious file disguised as software update or as a generic software. \n A Quid Pro Quo attack is a variant of baiting and differs in that instead of baiting a target with the promise of a good; a quid pro quo attack promises a service, or a benefit based on the execution of a specific action. \n For example, the hacker offers a service or benefit in exchange for information or access. ","Tailgating","The tailgating attack involves an attacker seeking entry to a restricted area which lacks the proper authentication. The attacker can simply walk in behind a person who is authorized to access the area. Humans are naturally helpful and this is exploited in Tailgating attacks. \n For example, person impersonates a delivery driver or a caretaker who is packed with parcels and waits when an employee opens their door. ","Prevention","• Being wary of unrealistic, tempting offers \n • Report suspicious emails/texts to the security team \n • Never open links by unknown sender \n • Don’t reply to communications that require you to input sensitive/personal data ","",""));
        return data;
    }
}
