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
        data.add(new ModuleData(1,"What is a cyber attack?","A cyber attack is an attack launched from one or more computers against another computer, multiple computers or networks. Cyber attacks can be broken down into two broad types: attacks where the goal is to disable the target computer, or attacks where the goal is to get access to the target computer's data and perhaps gain admin privileges on it.\nCyber attacks will always be a problem due to the side effects of freedom and ease of communicating online. Therefore education on different types of attacks is important.","Malware","Malware is a term used to describe malicious software that breaches a network through a vulnerability, typically when a user clicks a dangerous link or email attachment that then installs risky software. Once inside the system, malware can do the following:.\n • Blocks access to key components of the network (ransomware).\n • Installs malware or additional harmful software.\n • Covertly obtains information by transmitting data from the hard drive (spyware).\n • Disrupts certain components and renders the system inoperable","Ransomware and Spyware","Ransomware is a form of malware that encrypts a victim's files. The attacker then demands a ransom from the victim to restore access to the data upon payment.\nSpyware is a type of malware that aims to gather information about a person or organization, without their knowledge, and send such information to hack another entity without the consumer's consent.","Denial of Service","A denial-of-service attack floods systems, servers, or networks with traffic to exhaust resources and bandwidth. As a result, the system is unable to fulfill legitimate requests. Attackers can also use multiple compromised devices to launch this attack.","Trojan Horse","A Trojan horse or Trojan is a type of malware that is often disguised as legitimate software. Trojans can be employed by cyber-thieves and hackers trying to gain access to users' systems. Once activated, Trojans can enable cyber-criminals to spy on you, steal your sensitive data, and gain backdoor access to your system.","Man-In-The-Middle Attack","Man-in-the-middle (MitM) attacks, also known as eavesdropping attacks, occur when attackers insert themselves into a two-party transaction. Once the attackers interrupt the traffic, they can filter and steal data.\nTwo common points of entry for MitM attacks:\n1. On unsecure public Wi-Fi, attackers can insert themselves between a visitor’s device and the network. Without knowing, the visitor passes all information through the attacker.\n2. Once malware has breached a device, an attacker can install software to process all of the victim’s information","Prevention","• Use a firewall for your Internet connection.\n • Make backup copies of important business data and information.\n • Secure your Wi-Fi networks.\n • Install, use and regularly update antivirus and antispyware software.\n • Include encryption, file permissions and access controls"));
        data.add(new ModuleData(2,"What is Social Engineering?","Social Engineering is the act of tricking someone into sharing confidential/sensitive information by taking advantage of the victims’ natural tendencies and assumptions.\nSocial engineering usually takes two forms, one is a passive form where the attacker usually never sees or talks to the victim and the other is a more active approach to gathering or tricking individuals out of information.","Phishing","Phishing attacks are the most common type of attacks leveraging social engineering techniques. Attackers use emails, social media and instant messaging, and SMS to trick victims into providing sensitive information or visiting malicious URL in the attempt to compromise their systems.\nFor example, a notice that your email password will expire, with a link to change the password that leads to a malicious website.","Pretexting","The cybercriminal creates a false persona to obtain information or influence behaviour. Pretexting requires the attacker to build trust with no target.\nIn contrast to phishing attacks which mainly exploit fear and panic, pretexting relies on trust. For example, an attacker can impersonate an external IT services operator to ask internal staff for information that could allow accessing system within the organization.","Baiting and Quid Pro Quo Attacks","Baiting exploits the human’s curiosity. Baiting’s main characteristic is the promise of a good that hackers use to deceive the victims. For example, attackers use a malicious file disguised as software update or as a generic software.\nA Quid Pro Quo attack is a variant of baiting and differs in that instead of baiting a target with the promise of a good; a quid pro quo attack promises a service, or a benefit based on the execution of a specific action. For example, the hacker offers a service or benefit in exchange for information or access.","Tailgating","The tailgating attack involves an attacker seeking entry to a restricted area which lacks the proper authentication. The attacker can simply walk in behind a person who is authorized to access the area. Humans are naturally helpful and this is exploited in Tailgating attacks.\nFor example, person impersonates a delivery driver or a caretaker who is packed with parcels and waits when an employee opens their door.","Prevention"," • Being wary of unrealistic, tempting offers.\n • Report suspicious emails/texts to the security team.\n • Never open links by unknown sender.\n • Don’t reply to communications that require you to input sensitive/personal data","",""));
        data.add(new ModuleData(3,"Password security","Poor password security policies can act as a single point of failure that brings unauthorised access to personal user data.\nOne of the most common ways hackers break into accounts is by guessing the password through a set of powerful computers and algorithms. Hence, the easier the password is, the more easily intruders can gain access and control a device and the stronger the password is, the more protected you are from malicious intent. Especially due to the interconnectivity of smart devices, information is being shared across a larger landscape, leaving a greater number of devices vulnerable to misuse by unauthorised access.\nCommon consequences as a result include access to social media accounts, bank accounts, emails, confidential business, and personal data which can ultimately make you a victim of identity theft.","Password Guessing Strategies","1. Brute force: Using automated softwares and algorithms to guess password combinations by trying every possible character combination and most common passwords first. Since it inputs every combination, this method will eventually crack all passwords, however, a complex password will take many years to crack.\n2. Dictionary: Existent “dictionary” words are utilised to test out common password combinations.\n3. Phishing and Social Engineering: Phishing occurs when hackers target you with spoofed emails, calls and texts, posing to be from a real organisation to gain access to sensitive data provided by the user.\n4. Security Questions: Hackers can crack the answers to the questions by digging into your accounts, most often public social media profiles.","Best Practice for Users","TO DO.\n • More characters you have, the more difficult to crack. Ensure passwords are more than 10 characters in length to meet minimum security practices.\n • Use a range of uppercase, lowercase, numbers, symbols .\n • Use two factor authentication methods .\nIf an unknown device attempts to log in, the account will send an automated email, text to require verification .\n • Use passphrases rather than random combinations .\nCorrectHorseBatteryStaple a secure password as it is complex, hard to guess and above 10 characters .\nSubstitution such as using @ instead of a is not effective .\n • Install antivirus, anti-malware softwares on devices to build a defence link to minimise being targets of phishing, malicious links etc.\nDO NOT.\n • Use single dictonary words.\n • Use pet names, family names etc .\n • If you need to reset your passwords, don’t re-use your old password e.g Dog.Cat1 to Dog.Cat12 .\n • Use the same password for every account as once someone has infiltrated one account, they will attempt to break into others.\n • Use the same emails and passwords for both personal and business.","Common examples","Common examples of bad passwords.\n •  123456- Password- “your name”- Passw0rd1- Dogsaregood1.\nCommon examples of good passwords.\n •  1Ki79yd3- ?@$d3lt9d- Tm?’89Fdfio- CorrectHorseBatteryStaple","Summarised Key Points","1. Passwords must be long and complex as it takes longer for hackers to guessa. For example, do not use names, birthdates etc.\n2. Passwords must contain more than 10 characters and have a combination of symbols, upper cases and numbers.\n3. Do not use the same passwords on all accounts as if one device is infiltrated, the others are prone to vulnerability.\n4. Do not write down your passwords.","","","",""));
        data.add(new ModuleData(4,"Safe computing","As computing devices are becoming more and more integrated in our daily lives, it is important to understand the security risks involved. These could be anything from malwares to untrustworthy websites, which steal your personal data and allow unauthorised access by infiltrators. As new threats and attacks continually evolve over the digital landscape, it is vital for users to be equipped with better knowledge and awareness to safeguard against these security concerns.","Public Wi-Fi","Free, public Wi-Fi hotspots are readily available and everywhere, requiring no authentication so users can easily establish an internet connection. However, this connection is unsecure, and creates and avenue for hackers to infiltrate these devices, heightening the risk of sensitive data being stolen. Especially everyday activities which require login details, such as social media, emails and bank accounts, personal accounts are becoming increasingly susceptible and exposed to third-party access.\nThe most common data interception and eavesdropping strategies are.\n a. Man in the middle: Over an unsecured network, a device sending data to another device/website via the Wi-Fi connection e.g log in details, can be eavesdropped by hackers who position themselves in the middle of the transmission, and intercept the data.\n b. Packet sniffing: Similar to man-in-the-middle attacks, hackers monitors and intercepts unencrypted data packets sent across the unsecured network, using packet sniffer tools.\n c. Malware: Hackers can also utilise an unsecure Wi-Fi connection to indirectly install malware to devices. In particular, when users activate file transfer and syncing services, hackers can exploit this vulnerability by gaining access to the public folders and inject malware. As malwares are installed without your awareness, hackers are able to passively infiltrate the device and access all files.\nOther malicious intents to keep an eye out include:\n a. Malicious hotspots: Hackers can also trick users into believing that the connection they have set up is a legitimate hotspot connection. For example, if a user was at Starbucks, a rouge connection such as “Starbucks_AU” is used to imitate the actual connection. This will easily enable hackers to view your sensitive login information, data transfers, and files stored on your device.\n b. Compromised devices: Over an unsecured network, user devices can unknowingly connect to compromised ones. These devices have malware installed on them, so that it is able to relay sensitive data and log in details to hackers.\nHence, in the instance where a public Wi-Fi connection must be utilised, ensure the following.\n a. SSL connections: Only access websites that being with HTTPS and not HTTP, so that the connection between your browser and website is encrypted.\n b. Turn off sharing mode: Turn off all file sharing and syncing services on the device to minimise passive interceptions and malware installations.\n c. VPN: When data files must be sent to another device over the network utilise a virtual private network (VPN) so that all data transferred is encrypted.\n d. Enable firewalls: Firewalls can effectively block malware installation and unsafe websites.","Untrustworthy websites","HTTP stands for Hypertext Transfer Protocol and is a “stateless protocol” that enables web browsers and servers to communicate and exchange data over the web. For example, when you want to access a website, your browser must first send a request connection to the HTTP server, which is responsible to host the website. The server replies to the request with the response message, which opens the page of the website, and displays this on the browser. HTTP uses the Transmission Control Protocol (TCP) to send and receive the data packets of the website, and hence, remains focused on presenting the data to the user, rather than paying attention to how securely the data is transferred. Thus, on HTTP, user requests are visible to the public in plaintext, so that data can be easily intercepted and altered by anyone monitoring the connection. Especially in the case of transferring user sensitive data such as passwords and bank account details, this presents high privacy concerns.\nHence, the Hypertext Transfer Protocol Secure (HTTPS) is widely utilised instead to replace the unsecure HTTP connection. Most sites running over HTTPS also incorporates a redirection, so that if the user were to accidentally mistype and enter http://, it will redirect the connection so that it is secure. Over HTTPS, user requests and responses are encrypted, so that anyone monitoring the connection will only be able see a series of random characters rather than plaintext. In addition, web browsers also include a list of approved Certificate Authority (CA) which issue digital certificates to authenticate whether the web server is legitimate and trustworthy. This is represented by a green padlock next to the website which protects the user to ensure the transmitted data is accurate and free from tampering.\nHence, it is important that computers are to only access websites which begin with https:// and not http://. Firewalls and antivirus softwarwes can be utilised to block a connection to unsafe http:// websites.","Antivirus programs and firewall","The most common reason for computer failure and unauthorised intrusions are due to computer viruses, which are malicious programs written to damage the device and to steal personal data. Viruses are a type of malware which self-replicates by attaching its code to legitimate files, where it is spread through infected websites e.g online ads, USB drives and emails. Common impacts of viruses include:\n • Make a computer run slowly.\n • Prevent computers from starting.\n • Damage system operators.\n • Attack other devices by using them as hosts .\n • Steal personal information stored on the device.\nAntivirus software provides the computer with protection against incoming threats, most commonly, through malwares (note: virus is a type of malware).Through scheduled scans of user browsing history, files and device downloads, it is able to accurately pinpoint and delete malicious codes and software if present. As a result, antivirus software is vital to every computer, and needs to be kept up-to-date so that ongoing security vulnerabilities are continually being patched and addressed.\nHowever, it is important to note that antivirus software must be purchased from a trusted and well known, subscription-based program. This is because rogue anti-virus software exists online, where it is designed to imitate a legitimate antivirus software and pretends to have found an infection but, proceeds to install malware onto the device instead.\nThe overall benefit of installing an antivirus software is as summarised: .\n • Protects personal information of the user that is stored onto the device e.g passwords, credit card numbers etc.\n • Protects against online threats and malicious software.\n • Scans USB drives to minimise spread of potential infection.\n • Speeds up the computer as it de-clutters cached threats.\n • Protects from security vulnerabilities on a shared network.\n • Prevents access to unauthorised websites, such as spam sites and ads.\nWhile antivirus software protects computers against malicious softwares, firewalls are the initial shield that keeps these threats from having access to the device in the first place. Hence, it is crucial that firewalls are enabled as it examines all network traffic to the device, and only allows safe and authorised data through. The most common method that firewalls use is packet filtering, where incoming data packets over the network is filtered against a set of pre-existing security standards. If it is flagged by the filters, the data is not allowed through. Thus, firewalls and antivirus software should be utilised in conjunction as since firewalls is only the first layer of security, it is unable to block all cyberattacks.","Update computer security softwares","It is essential that all computers are up-to-date with the latest software updates as they include important security patches and bug fixes that were previously not addressed. This includes updating both the operating system and softwares, as often, malware attacks target these security vulnerabilities first.","","","",""));
        data.add(new ModuleData(5,"Safe Mobile Practice","Nearly everyone has a mobile device right? We begin to rely on them for pretty much everything: messaging, maps, online shopping, banking and finally for phone calls. It is concerning that we do so many other functionalities on top of phone calls, leaving our devices one of the fastest growing attack surfaces for cybercriminals. Our devices contain a large amount of personal information, where applications pave paths for other applications and provide them a gateway on accessing them. For example, online shopping applications access your bank accounts details, which are vulnerable to cyberattacks and out of your control. Devices also provide direct access to emails, text messages and social media accounts, which store an abundance of personal information that can be stolen by cybercriminals, and utilised to forge your identity.\nMost often, data is accessed when attackers physically get a hold of your device when they are misplaced or stolen. However, in the digital age, there are also a range of online exploits that can take advantage of your phone’s Bluetooth, Wi-Fi networks and cellular connections to gain virtual access to your phone.\nSummarised below are the most common mobile security threats .\n","Physical Device Breach and Password Security Importance","A misplaced or stolen device is a major security risk, especially if there are no login PIN, passwords or data encryption services. Among users who do set up login passwords, however, utilise an extremely simple, bare minimum four-character code that is easy to crack. In 2017, a study conducted by Verizon stated that weak or stolen passwords were the cause of over 80% of hacking related breaches. Especially mobile devices in particular, users are continually seeking ways to ease their sign in process, simplifying and using the same passwords for all accounts.\nSensitive data and files stored on the device are thus vulnerable to unauthorised access if they are not kept physically secure. Anyone can search, steal files, read private messages and emails without your knowledge.","Wi-Fi Interference","Mobile devices are only as secure as the network it connects and transmits data across. However, over a quarter of devices utilised worldwide are connected to public and potentially insecure Wi-Fi networks.\nSimilar to computers, mobile device also experience man in the middle attacks over an unsecured network, where network connections are intercepted and eavesdropped by cybercriminals who position themselves in the middle of the transmission. Hence, all the information that you are transmitting across the network, such as logins details, emails, files are also being transmitted to another person.","Social Engieering Attacks","Mobile users are at the greatest risk of receiving and falling for social engineering attacks, especially phishing. Phishing attacks have grown over 65% over 2017, and 91% of them start with emails. Email applications display limited information in comparison to desktop view, which increases the likeliness of phishing success. For example, mobile notifications incorporate one-tap options for opening links and responding to emails and display limited sender information.\nSocial engineering attacks have also broadened their scope, targeting Facebook Messenger, Whatsapp and gaming applications over the past year. Additionally, phishing applications which are designed to look like legitimate applications are beginning to infiltrate the official app stores, secretly collecting the information you input, such as, passwords, bank account and login details.","Mobile Adware and Spyware","Mobile adwares are programs or scripts installed on your phone without your consent, to collect data and online user behaviours to better target you with advertisements. Adwares utilise mobile browsers to collect browsing history and personal demographics to tailor pop-up advertisements, which additionally, slows down the device, making it more prone to frequent system crashes.\nSpyware on the other hand are responsible to further collect sensitive information, such as location, internet providers and celluar usage, mobile phone contacts, messages, emails and even user names, passwords and bank account numbers. Additionally, spyware even provides access to stored data files, such as images, videos, and files as well as intercept phone calls.\nThe most common ways to be in contact with adware and software is drive by downloads from websites infected with adware or spyware , or unknowingly downloading applications which contain them. Remote installations also exist, whereby users may accidentally click a link or email attachment.","Trojans","Trojans are a type of malicious code or software attached to applications which look extremely official, but is instead a fake version of the actual application. Hence, it is incredible easy for users to install the incorrect one, as they are usually placed on app stores.\nWhen these applications are installed, they hijack your mobile device and copy the information stored. Thus, Trojans can potentially have access and capture everything, from logins and passwords, to pictures and files, system information, banking details and even login keystrokes. Additionally, Trojans even allow the attacker to modify the stored data, disrupt application services and even disable anti-malware protection to further the impact.","Mobile Security Best Practices","Use a strong log-in password.\nBy setting a strong login, it is considerably more difficult for attackers to gain access to your phone and your information. One strong login example is to utilise fingerprint scans. Logging in fingerprints result in a much more complicated combination than any password and is more difficult to recreate.\n •  Disable Bluetooth and Wi-fi connections when unused.\nWhen these functions are turned on, they are broadcasting your information and network connection to the open. Cybercriminals can passively connect to your device and gain access to your information, inject malware and indirectly utilise services with your details. Hence, ensure that devices do not automatically connect to networks without permission.\n •  Assess the safety of applications before installing.\nMobile applications are all created By third parties, and Hence it is not guaranteed that all applications on the app store are safe and legitimate. Even though filters and screenings are utilised By the store to test the security of the applications, unsafe applications filled with malware still exist. Additionally, an important rule tonote is to never download applications that are not on the official store, such as APK files from browsers.\nFurther, delete applications and Disable application services once they are not required, as they will keep communicating with your device and access your data within the background to copy and export to the system developers. Most commonly, these applications will have access to services such as: email, Wi-fi, location based services, file sharing services, Bluetooth.\n •  Disable location services when not needed.\nMost applications utilise location based services to your whereabouts, which is collated and sold, Most often utilised for targeted advertisements and marketing campaigns. Ultimately, this introduces security risks because due to increased personal data within the digital landscape.\n •  Back up and upgrade devices.\nUpgrading your phone every time a new update is introduced is crucial as it incorporates new security features and patches that were previously not recognised. Cybercriminals can take advantage of vulnerabilities in operation systems and applications if they are not properly patched or updated, which, puts all the data stored on the system at risk.\n •  Minimise usage of public power sockets.\nDo not Use or Minimise the usage of charging your phone in public charging stations or USB outlets as it could be a data link transmitter instead. Over the connection, your information can be exported to the host, personal data wiped and malware injected without your knowledge.\n •  Install security software.\n •  Install security software such as antivirus, encryption services to prevent unauthorised access and malware installations"));
        data.add(new ModuleData(6,"Physical Threats","The objective of physical security is to safeguard personnel, information, equipment, IT infrastructure, facilities and all other company assets. Physical security must be implemented correctly to prevent attackers from gaining physical access and take what they want. Physical security involves the use of multiple layers of interdependent systems","Deterrence Methods","The goal of deterrence methods is to convince potential attackers that a successful attack is unlikely due to strong defenses. This is an initial layer of security for an office. Some common examples are warning signs, fences, restricted access points, security lighting.","Intrusion Detection and Surveillance","Surveillance is the monitoring of behaviour, activities or information. Common surveillance tools include alarm systems, video surveillance and sensors.\nAlarm systems can be installed to alert security personnel when unauthorized access is attempted. Alarm systems work in tandem with physical barriers, mechanical systems, and security guards, serving to trigger a response when these other forms of security have been breached.","Access Control","Access control methods are used to monitor and control traffic through specific access points and areas of the secure facility. This is done using a variety of systems including CCTV surveillance, identification cards, biometric readers and control systems such as locks and doors.\nThere are three control systems: mechanical access, electronic access and identification systems.\nMechanical access control systems include gates, doors and locks. Electronic access is the evolution of mechanical access control when keys and locks became unmanageable. Electronic access control managers larger user populations. These systems are often interfaced with turnstiles for entry control to prevent unauthorized access. Identification systems and access policies are procedures and policies that manage the ingress within the restricted area.","Security Guards","All of the technological systems that are employed to enhance physical security are useless without a security force that is trained in their use and maintenance, and which knows how to properly respond to breaches in security. Security personnel perform many functions: patrolling facilities, administering electronic access control, responding to alarms, and monitoring and analyzing video footage.","","","",""));
        return data;
    }
}
