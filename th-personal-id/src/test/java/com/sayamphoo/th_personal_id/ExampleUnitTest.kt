package com.sayamphoo.th_personal_id

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    //false true
    //Not enough length!!  //CodeIsCorrect!! //Id Not correct!!
    //6678447273273


    //สมบูรณ์
    @Test
    fun test1() {
        val reply = Personal().checkPersonalTH("6678447273273")
        assertEquals(true,reply.propriety)
        assertEquals("200",reply.code)
        assertEquals("CodeIsCorrect!!",reply.message)
    }
    //รหัสไม่ถูก
    @Test
    fun test2() {
        val reply = Personal().checkPersonalTH("6678447273270")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)
        assertEquals("Id Not correct!!",reply.message)
    }
    //รหัสไม่ครบ 13 หลัก
    @Test
    fun test3() {
        val reply = Personal().checkPersonalTH("667844727327")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)
        assertEquals("Not enough length!!",reply.message)
    }

    //รหัสเกิน 13
    @Test
    fun test4() {
        val reply = Personal().checkPersonalTH("66784472732700012")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)
        assertEquals("Not enough length!!",reply.message)
    }

    //มีตัวหนังสือ
    @Test
    fun test5() {
        val reply = Personal().checkPersonalTH("test134901112")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)
        assertEquals("Id Not correct!!",reply.message)
    }
//ว่าง
    @Test
    fun test6() {
        val reply = Personal().checkPersonalTH("")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)

        assertEquals("Not enough length!!",reply.message)
    }

    //ตังหนังสือ
    @Test
    fun test7() {
        val reply = Personal().checkPersonalTH("abcdefghasdfg")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)
        assertEquals("Id Not correct!!",reply.message)
    }

    //ตังหนังสือ
    @Test
    fun test8() {
        val reply = Personal().checkPersonalTH("zcv")
        assertEquals(false,reply.propriety)
        assertEquals("403",reply.code)
        assertEquals("Not enough length!!",reply.message)
    }
}