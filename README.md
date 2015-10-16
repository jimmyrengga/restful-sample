# restful-sample

- Spring boot
- Spring restful

Jalankan dengan menggunakan perintah mvn clean install, kemudian mvn spring-boot:run. 
Aplikasi dapat diakses pada alamat : http://localhost:8080
uri API yang tersedia : 
- ../profile dengan menggunakan httpmethod POST untuk menyimpan data profile. sample json yang bisa digunakan sebagai berikut :
  {
	"id":"test1",
	"username":"test1",
	"address":"address 1",
	"phoneNumber":"123",
	"email":"test@mail.com",
	"hobbies":[
		"sepakbola",
		"renang"
	]
  }

- ../profile dengan menggunakan httpmethod GET untuk menampilkan semua data profile
- ../profile/{username} dengan menggunakan httpmethod GET untuk menampilkan data profile berdasarkan username
- ../profile/{username} dengan menggunakan httpmethod DELETE untuk menghapus data profile sesuai dengan username	