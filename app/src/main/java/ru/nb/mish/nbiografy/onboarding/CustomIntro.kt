package ru.nb.mish.nbiografy.onboarding

import android.content.Intent
import android.os.Bundle
import com.github.paolorotolo.appintro.AppIntro2
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.ui.MainActivity

class CustomIntro : AppIntro2() {
    override fun init(savedInstanceState: Bundle?) {


        addSlide(SampleSlide.newInstance(R.layout.onboarding_slide1))
        addSlide(SampleSlide.newInstance(R.layout.onboarding_slide2))

    }

    private fun loadMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onNextPressed() {

    }

    override fun onDonePressed() {
        finish()
    }

    override fun onSlideChanged() {

    }

}