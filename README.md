# Tutorial APAP
## Authors
* **Afnadiati Hartatika** - *1906398931* - *C*

---
## Tutorial 4
### What I have learned today

### Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!
   - th:include adalah cara untuk memasukkan konten dari sebuah fragment tetapi tidak menyisipkan tag fragment itu sendiri.
   - th:replace adalah cara untuk memasukkan konten dari sebuah fragment dengan mengganti tag saat ini dengan tag yang 
     mendefinisikan fragment tersebut.
   

2. Jelaskan apa fungsi dari th:object!
   
   th:object berfungsi sebagai penentu objek yang akan di submit dalam sebuah data formulir yang dikirimkan. 
   Setiap field data formulir dipetakan menggunakan atribut th:field="*{name}", name tersebut mendefinisikan properti 
   objek yang sesuai dengan field.
   

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
   - tag dengan tanda * digunakan untuk mengisi field data dari formulir, biasanya diterapkan pada formulir edit dan input.
   - tag dengan tanda $ menandakan bahwa tag tersebut merepresentasikan suatu objek atau variabel dari sebuah kumpulan data, 
     biasanya digunakan untuk mengambil nilai yang akan ditampilkan pada template html.


### What I did not understand
- [ ] Kategorisasi penggunaan masing-masing tag Thymeleaf

### References:

- https://www.baeldung.com/spring-thymeleaf-fragments
- https://www.baeldung.com/thymeleaf-in-spring-mvc
- https://www.sinaungoding.com/yuk-belajar-web-menggunakan-spring-boot2/
- https://anshulgnit.blogspot.com/2018/05/difference-between-thymeleaf-attribute-replace-insert-and-include.html


---
## Tutorial 3
### What I have learned today

### Pertanyaan
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
   (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
   - @AllArgsConstructor: membuat constructor dengan menggunakan argumen.
   - @NoArgsConstructor: membuat constructor tanpa menggunakan argumen.
   - @Setter: menghasilkan fungsi setter.
   - @Getter: menghasilkan fungsi getter.
   - @Entity: mendefinisikan nama entity dari class.
   - @Table: menetapkan nama tabel SQL.
   

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method
   tersebut?

   Method findByNoBioskop berfungsi sebagai interface yang akan menghubungkan method 
   implementasinya pada file BioskopServiceImpl dengan database. Method tersebut digunakan
   untuk mencari semua bioskop berdasarkan nomornya.


3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn.

   @JoinTable melakukan penyimpanan id dari kedua entity ke dalam tabel terpisah, 
   sedangkan @JoinColumn melakukan penyimpanan id entity lain di kolom baru dengan table yang sama.


4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa
   kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
   perbedaan nullable dan penggunaan anotasi @NotNull.
   - name: nama dari kolom foreign key.
   - referencedColumnName: nama kolom yang dirujuk oleh foreign key.
   - nullable: menentukan kondisi apakah kolom foreign dapat tidak memiliki nilai atau tidak.
   - @NotNull: field yang memiliki karakteristik @NotNull form tidak boleh dikosongkan, tetapi fieldnya bisa kosong. 


5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER.

   FetchType.LAZY digunakan saat persistence provider runtime harus bekerja dengan cepat, sedangkan FetchType.LAZY
   digunakan saat persistence yang bekerja tidak memerlukan kerja keras atau dapat diproses perlahan-lahan.
   Penggunaan CascadeType.ALL berarti bahwa setiap perubahan yang terjadi pada suatu entity akan mempengaruhi 
   (atau ikut berubah) entity lain yang memiliki relasi dengannya.


### What I did not understand
- [ ] Kapan waktu yang tepat untuk menggunakan repository? 
- [ ] Perbedaan model dengan DB

### References:
- http://www.intelligentprogrammer.com/index.php/2021/01/01/how-to-use-lombok-in-spring-boot/
- https://www.baeldung.com/jpa-entity-table-names
- https://javakeypoint.wordpress.com/2020/04/21/difference-between-joincolumn-and-jointable-in-hibernate/
- https://docs.oracle.com/javaee/6/api/javax/persistence/JoinColumn.html
- https://www.baeldung.com/java-bean-validation-not-null-empty-blank
- https://atautowired.wordpress.com/2013/05/08/fetchtype-lazy-vs-fetchtype-eager-in-javax-persistance/
- https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/

---
## Tutorial 2
### What I have learned today

### Pertanyaan
1. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi 
   
    Jawab: Tidak dapat diakses atau terjadi *Whitelable Error Page*, karena view template yang diimplementasikan yaitu **"add-bioskop"** pada Controller belum dibuat.


2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
   
    Jawab: @Autowired merupakan fitur component-scan yang disediakan oleh Spring Framework. @Autowired bekerja dengan melihat isi package dan mencari class-class yang memiliki anotasi tertentu seperti @Repository, @Service, @Controller, dan @Component. Setelah class-class tersebut ditemukan, lalu dilakukan inject untuk semua dependency tanpa perlu menyediakan setter, getter, dan constuctor. Pada Lab kali ini @Autowired diimplementasikan sebagai Controller.


3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
   
   Jawab: Link tersebut tidak dapat bekerja, karena kekurangan parameter yaitu jumlah studio yang wajib diisi belum dimasukkan, sehingga link gagal dieksekusi.


4. Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung,
   link apa yang harus diakses?

   Jawab: Diasumsikan bioskop dengan nama Bioskop Maung memiliki ID = 1, sehingga dapat diakses pada link berikut http://localhost:8080/bioskop/view?idBioskop=1


5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

   Jawab:
   
   Link untuk penambahan data: http://localhost:8080/bioskop/add?idBioskop=2&namaBioskop=Bioskop%20AKU&alamat=Depok%20Fasilkom&noTelepon=081xxx&jumlahStudio=20
   ![img.png](img.png)
   Halaman daftar bioskop
   ![img_1.png](img_1.png)

### Latihan
1. Pada BioskopController tambahkan sebuah method view Bioskop dengan menggunakan Path
   Variable. Misalnya, kamu ingin memasukkan data sebuah Bioskop yang memiliki idBioskop
   1, untuk melihat data yang baru dimasukkan tersebut, user dapat mengakses halaman
   http://localhost:8080/bioskop/view/id-bioskop/1.
   ![img_2.png](img_2.png)
   

2. Tambahkan fitur untuk melakukan update jumlahStudio Bioskop berdasarkan idBioskop.
   Misalnya, setelah melakukan add Bioskop pada tahap 1 bab View Template, cobalah untuk
   mengubah jumlahStudio objek Bioskop tersebut menjadi 999 dengan mengakses halaman
   http://localhost:8080/bioskop/update/id-bioskop/1/jumlah-studio/999
   Tampilkan juga sebuah halaman yang memberikan informasi bahwa data tersebut telah
   berhasil diubah.
   ![img_3.png](img_3.png)
   

3. Tambahkan fitur untuk melakukan delete Bioskop berdasarkan idBioskop. Misalnya, setelah
   melakukan add Bioskop pada tahap 1 bab View Template dan melakukan update seperti pada
   latihan nomor 2, cobalah untuk melakukan delete data tersebut dengan mengakses halaman
   http://localhost:8080/bioskop/delete/id-bioskop/1. Tampilkan sebuah halaman yang
   memberikan informasi bahwa data tersebut telah berhasil dihapus.
   
   ![img_4.png](img_4.png)

### What I did not understand
- [ ] Perbedaan dari masing-masing MVC 
- [ ] Waktu yang tepat untuk menggunakan MVC

### References:
- https://software.endy.muhardin.com/java/memahami-dependency-injection/

---
## Tutorial 1
### What I have learned today

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker adalah alat yang digunakan untuk melacak bug dan feature requests selama pengembangan produk. Manfaat yang bisa didapat melalui penggunaan Issue Tracker antara lain centralized issue management, issue history tracking, pemberian bagian kerja yang sesuai, monitoring tindakan setiap terjadi masalah, meningkatkan efisiensi, dan kolaborasi tim.

2. Apa perbedaan dari git merge dan git merge --squash?
git merge => menggabungkan commit dari suatu branch dengan branch lainnya.
git merge --squash => adalah cara agar semua commit dari header branch digabungkan menjadi 1 commit, kemudian commit tersebut ditambahkan ke main branch. 

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi? VCS dapat menyelesaikan remote repository dengan baik, mampu meningkatkan efektivitas kerja secara berkelompok, dapat memberikan kesempatan untuk mengatur janis alur kerja yang cocok.

### Spring
1. Apa itu library & dependency?
Dependency membantu mengaitkan antar class dan menjaga class-class tersebut tetap independen. Sedangkan library menyimpan formula yang dapat digunakan secara berulang.

2. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven merupakan build tool yang biasa digunakan pada proyek Java. Maven dapat membantu mengkompilasi source code dengan mudah, melakukan testing, dan menginstalasi library. Selain Maven, terdapat build tools lain yang dapat digunakan pada Java Project, yaitu Gradle, Jenkins, Apache Ant, dan sejenisnya.

3. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
Enterprise Java Beans (EJB, JNDI), Database access (JDBC, MyBatis, ORM), Transaction management (JTA, Hibernate, JDBC), dan Remote access (Web Services, RMI).

4. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
@RequestParam mengekstrak nilai dari dari query string dan perlu di encode, sedangkan @PathVariable mengekstrak nilai dari jalur URI dan tidak perlu di encode. @RequestParam sebaiknya digunakan saat ingin mengambil nilai parameter menggunakan code, sedangkan @PathVariable tidak perlu.

### What I did not understand
Belajar dan berlatih menggunakan Spring Framework bertujuan untuk menyatukan berbagai solusi dan ide kreatif agar menjadi nyata. Salah satu keuntungan yang didapat dengan menggunakan Spring Framework adalah dapat mengimplementasikan program melalui beberapa layer, sehingga dapat mengurangi dependencies dan layernya dapat dibongkar pasang. Beberapa hal yang belum saya pahami yaitu terkait istilah-istilah yang digunakan belum terlalu familiar.


References:
- https://developers.google.com/issue-tracker
- https://monday.com/blog/project-management/issue-tracker/
- https://ooloo.io/project/github-flow/task-1-merge-vs-squash-merge
- https://git-scm.com/book/id/v2/Memulai-Tentang-Version-Control
- https://www.tutorialspoint.com/spring/spring_dependency_injection.htm
- https://www.petanikode.com/java-maven/
- https://www.getfilecloud.com/blog/2019/06/top-10-build-automation-software-for-2019/#.YTjALBnitnI
- https://www.baeldung.com/spring-requestparam-vs-pathvariable
- [PPT Materi Kuliah APAP] Development using MVC 