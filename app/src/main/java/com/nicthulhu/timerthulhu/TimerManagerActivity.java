package com.nicthulhu.timerthulhu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.support.v7.widget.CardView;

import java.util.ArrayList;


public class TimerManagerActivity extends Activity {
    ArrayList<TimerOptionsCard> timerOptionsCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_manager);

        addTimerOptionsView(new TimerOptions());
    }

    void addTimerOptionsView(TimerOptions timerOptions){
        //todo pass timer options into timer card
        LinearLayout timer_container = (LinearLayout)findViewById(R.id.timer_options_container);
        timerOptionsCards.add(new TimerOptionsCard(this, timer_container));
    }

    class TimerOptions{
        boolean exact;
        boolean whileIdle;

        boolean monday;
        boolean tuesday;
        boolean wednesday;
        boolean thursday;
        boolean friday;
        boolean saturday;
        boolean sunday;

        long window_begin;
        long window_end;
    }

    class TimerOptionsCard{
        TimerOptions timerOptions = new TimerOptions();
        CardView card; //the top level
        LinearLayout top; //to organize what's on the card

        ImageButton days; //toggle to show or hide days
        boolean daysShowing = false;
        Drawable upArrow;
        Drawable downArrow;

        CheckBox exact;
        CheckBox whileIdle;

        //repeat days...
        CheckBox monday;
        CheckBox tuesday;
        CheckBox wednesday;
        CheckBox thursday;
        CheckBox friday;
        CheckBox saturday;
        CheckBox sunday;

        TimerOptionsCard(Context context, ViewGroup addToThis){
            card = new CardView(context);
            addToThis.addView(card);
            top = new LinearLayout(context);
            top.setOrientation(LinearLayout.VERTICAL);
            card.addView(top);

            exact = new CheckBox(context);
            whileIdle = new CheckBox(context);
            InitCheckBox(exact, "Exact", timerOptions.exact);
            InitCheckBox(whileIdle, "WhileIdle", timerOptions.whileIdle);
            top.addView(exact);
            top.addView(whileIdle);

            //drawable arrows for show/hide
            //todo make these drawables themeable?
            upArrow = context.getDrawable(R.drawable.ic_keyboard_arrow_up_black);
            downArrow = context.getDrawable(R.drawable.ic_keyboard_arrow_down_black);

            days = new ImageButton(context);
            days.setImageDrawable(downArrow);
            days.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (daysShowing){
                        RemoveDayCheckBoxes();
                        days.setImageDrawable(downArrow);
                        daysShowing = false;
                    }else{
                        AddDayCheckBoxes();
                        days.setImageDrawable(upArrow);
                        daysShowing = true;
                    }
                }
            });
            top.addView(days);



            monday = new CheckBox(context);
            tuesday = new CheckBox(context);
            wednesday = new CheckBox(context);
            thursday = new CheckBox(context);
            friday = new CheckBox(context);
            saturday = new CheckBox(context);
            sunday = new CheckBox(context);
            InitCheckBox(monday, "Monday", timerOptions.monday);
            InitCheckBox(tuesday, "Tuesday", timerOptions.tuesday);
            InitCheckBox(wednesday, "Wednesday", timerOptions.wednesday);
            InitCheckBox(thursday, "Thursday", timerOptions.thursday);
            InitCheckBox(friday, "Friday", timerOptions.friday);
            InitCheckBox(saturday, "Saturday", timerOptions.saturday);
            InitCheckBox(sunday, "Sunday", timerOptions.sunday);

        }

        void InitCheckBox(CheckBox box, String label, boolean checked){
            box.setText(label);
            box.setChecked(checked);
        }

        void AddDayCheckBoxes(){
            top.addView(monday);
            top.addView(tuesday);
            top.addView(wednesday);
            top.addView(thursday);
            top.addView(friday);
            top.addView(saturday);
            top.addView(sunday);
        }

        void RemoveDayCheckBoxes(){
            top.removeView(monday);
            top.removeView(tuesday);
            top.removeView(wednesday);
            top.removeView(thursday);
            top.removeView(friday);
            top.removeView(saturday);
            top.removeView(sunday);
        }

        void UpdateTimerOptions(){{
            timerOptions.monday = monday.isChecked();
            timerOptions.tuesday = tuesday.isChecked();
            timerOptions.wednesday = wednesday.isChecked();
            timerOptions.thursday = thursday.isChecked();
            timerOptions.friday = friday.isChecked();
            timerOptions.saturday = saturday.isChecked();
            timerOptions.sunday = sunday.isChecked();
        }
        }
    }
}
