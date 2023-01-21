## ABOUT APP
FEEDER
This is Feeder, app for people who is in love with music. The application uses Firebase Authentication and Realtime Database services.

![image](https://user-images.githubusercontent.com/115501603/212770234-132f5988-0b35-4b69-ae93-8c15c584ba27.png)
##
##
After downloading the app, user should register or if he or she has an account, should login. After authentication user can post a review on an artist and about his or her song.

![image](https://user-images.githubusercontent.com/115501603/212770882-b60bbfaf-a3ca-4a05-9982-539b0edd5c58.png)
##
##
Here is following steps about how to use the app, you can follow the instructions on the following image:

![image](https://user-images.githubusercontent.com/115501603/212771114-13e50720-6d34-449a-8938-e309e7f24331.png)
##
##
## FEATURES

- Changing password from Profile page or during signing in.
- Is easy to use, easy to understand the app.
- After registering user does not have to sign in again.
- Userfriendly design.

![image](https://user-images.githubusercontent.com/115501603/212771535-e88147e3-e585-485f-8263-911b03b7c6b6.png)


Enable, configure terminal, int fa/ga, ip add(ip, subn), no shutdown - აიპების მისათითებლად კომანდები
ho – როუტერის სახელის დარქმების კომანდი
banner motd “Text” - შესვლამდე აგდებს ამ კომანდში ჩაწერილი ტექსტს
ip route (კომპის ip, subn, როუტერის ip) - კომანდი რათა ასწავლო სხვა ქსელები სხვა როუტერს
write, copy running config tftp: - tftp-ს სამისამართო კომანდი
ip ftp usernamo / password - პაროლის და სახელის მისანიჭებელი კომანდი
int gig 0/0 - ეს სიტყვაზე , ip helper-address (DHCP ადრესი უნდა აქ) – DHCP -ის მისათითებელი კომანდი როუტერისთვის
enable password (რამე) – enable-ს პაროლის დაყენების კომანდი
enable secret (რამე) - ანაცველბს enable-ს პირველად პაროლს
line console 0 , password (რამე), login - სულ სულ თავიდან გვაწერინებს პაროლს ამ კომანდით
line vty 0 15, password (რამე), login - ყველა არხზე იწერება ეს ბრძანება 
ena, conf t, router rip, version 2, no auto-summary, network(ip add), 


enable, conf t, ip dhcp pool ?, ip dhcp pool (saxeli), network(ip) ?, network(ip-უკვე გაწერილია, subn mask-ვამატებთ), default-router(ვწერთ აქ gateway-ს), dns-server(dns ip), domain-name(დომეინის სახელისთვის - სავალდებულო არაა), exit, ip dhcp excluded-address
 (პირველი ip - მეორე ip, ამ პირვეპი აიპიდან მეორე აიპამდე არ ჩათვლის DHCP) 


int fa 0/5, switchport mode access, switchport access vlan 10 – vlan-ის მინიჭება

fa 0/1, switchport mode trunk - თრანაქზე გადაყვანა
* = ricxvia
inf fa */*,  swi mo tr, swirtchport trunk native vlan *.  – native vlan-ის შეცვლა

interface range fastEthernet 0/2-3

router rip, version 2, no auto-summary, network (172.16.0.0 - სიტყვაზე).
Passive- interface gi 0/1 - ინფორმაციის აღარ მიწოდება
Router rip, default-information originate - გავრცელება ინფოსი რიპზე
Username () password(), enable secret (), ip ssh version 2, ip domain-name (), crypto key generate rsa, აქ რაიმე ციფრი რომელიც გვინდა მერე, line vty 0 15, login local, transport input ssh.	



ip access-list standard (saxeli)
deny host 172.16.10.3 - ამით ვუთიშავთ ერთ ჰოსტს წვდომას
permit any
exit
int gi 0/0 - შევდივართ რომელიმე ინტერფეისზე რომელზეც გვინდა
ip access-group (saxeli rac davarqvit) in or out
exit

interface loopback (saxeli an 0dan)
ip add sityvaze:172.16.31.1 255.255.255.0
desc (aq shegvidzlia chawerot rac gvinda is)
exit

192.168.0.0/26

255.255.255.192

256-192 = 64

192.168.0.1 - 192.168.0.62

192.168.0.63




192.168.0.64/27

255.255.255.224

256-224 = 32

192.168.0.65 - 192.168.0.94

192.168.0.95





192.168.0.96/27

255.255.255.224

256-224 = 32

192.168.0.95 - 192.168.0.126

192.168.0.127
