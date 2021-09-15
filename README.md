# Tutorial APAP
## Authors
* **Afnadiati Hartatika** - *1906398931* - *C*

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