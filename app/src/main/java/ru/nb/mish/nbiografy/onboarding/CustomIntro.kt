package ru.nb.mish.nbiografy.onboarding

import android.os.Bundle
import com.github.paolorotolo.appintro.AppIntro2
import ru.nb.mish.nbiografy.R

class CustomIntro : AppIntro2() {
    override fun init(savedInstanceState: Bundle?) {

        addSlide(SampleSlide.newInstance(R.layout.onboarding_slide1))
        addSlide(SampleSlide.newInstance(R.layout.onboarding_slide2))
    }

    override fun onNextPressed() {
    }

    override fun onDonePressed() {
        finish()
    }

    override fun onSlideChanged() {
    }
}