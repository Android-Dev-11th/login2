package com.example.login2

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    //method_condition_result
    //PASSWORDS
    @Test
    fun validatePassword_emptyPassword_isFalse(){
        val actual = RegistrationUtil.validatePassword("", "")

        assertThat(actual).isFalse()
    }
    @Test
    fun validatePassword_passwordsDontMatch_isFalse(){
        val actual = RegistrationUtil.validatePassword("A1bcdef", "1Abcdef")
        assertThat(actual).isFalse()
    }
    @Test
    fun validatePassword_minLength8_isFalse(){
        val actual = RegistrationUtil.validatePassword("Yay1", "Yay1")
        assertThat(actual).isFalse()
    }
    @Test
    fun validatePassword_atLeastDigit_isFalse(){
        val actual = RegistrationUtil.validatePassword("Abcdefgh", "Abcdefgh")
        assertThat(actual).isFalse()
    }
    @Test
    fun validatePassword_atLeastCapital_isFalse(){
        val actual = RegistrationUtil.validatePassword("1bcdefgh", "1bcdefgh")
        assertThat(actual).isFalse()
    }
    @Test
    fun validatePassword_doesWork_isTrue(){
        val actual = RegistrationUtil.validatePassword("1Abcdefgh", "1Abcdefgh")
        assertThat(actual).isTrue()
    }

    //USERNAME
    @Test
    fun validateUsername_alreadyExists_isFalse(){
        val actual = RegistrationUtil.validateUsername("bob")
        assertThat(actual).isFalse()
    }
    @Test
    fun validateUsername_lessThanThree_isFalse(){
        val actual = RegistrationUtil.validateUsername("ya")
        assertThat(actual).isFalse()
    }
    @Test
    fun validateUsername_doesWork_isTrue(){
        val actual = RegistrationUtil.validateUsername("Yay")
        assertThat(actual).isTrue()
    }

    //NAME
    @Test
    fun validateName_isntEmpty_isFalse(){
        val actual = RegistrationUtil.validateName("")
        assertThat(actual).isFalse()
    }
    @Test
    fun validateName_doesWork_isTrue(){
        val actual = RegistrationUtil.validateName("Yay")
        assertThat(actual).isTrue()
    }

    //EMAIL
    @Test
    fun validateEmail_properSyntax_isFalse(){
        val actual = RegistrationUtil.validateEmail("yaygmailcom")
        assertThat(actual).isFalse()
    }
    @Test
    fun validateEmail_doesWork_isTrue(){
        val actual = RegistrationUtil.validateEmail("yay@gmail.com")
        assertThat(actual).isTrue()
    }
}