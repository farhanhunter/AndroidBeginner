package com.example.myfarhanapp

object CalenderData {
    private val namaKegiatan = arrayOf("Farhan Adi",
        "Arfan Yoga",
        "Yan Tirta",
        "Damar Bayu",
        "Zainul Muttaqin",
        "Arroyan Cahya",
        "Zulfikar Dia",
        "Virga Ghandy",
        "Rio Alamsyah",
        "Mukhammad Nur")

    private val jamDetails = arrayOf("Mahasiswa yang belajar dicoding pemrograman android pemula",
    "Mahasiswa yang sering disuruh oleh pak fery",
    "Mahasiswa yang sering online kuliah",
    "Mahasiswa yang pulang pergi kampus",
    "Mahasiswa yang suka dibarbasari",
    "Mahasiswa yang memasak dan mengerjakan tugas degan sungguh2",
    "Mahasiswa yang sedang magang",
    "Mahasiswa yang suka pulang kampung setiap minggu",
    "Mahasiswa yang suka loli",
    "Mahasiswa yang suka dikosan terus")

    private val noTelfon = arrayOf("0866666666",
        "08212121212",
        "08190222222",
        "08196555555",
        "08119222222",
        "08232323232",
        "08242455555",
        "082121213212",
        "082177722727",
        "082123213217")

    private val calendarIc = intArrayOf(R.drawable.bapak1,
    R.drawable.bapak2,
    R.drawable.bapak3,
    R.drawable.bapak4,
    R.drawable.bapak5,
    R.drawable.bapak6,
    R.drawable.bapak7,
    R.drawable.bapak8,
    R.drawable.bapak9,
    R.drawable.bapak10)

    val listData: ArrayList<Meet>
        get() {
            val list = arrayListOf<Meet>()
            for (position in calendarIc.indices) {
                val meet = Meet()
                meet.name = namaKegiatan[position]
                meet.detail = jamDetails[position]
                meet.photo = calendarIc[position]
                meet.phone = noTelfon[position]
                list.add(meet)
            }
            return list
        }
}