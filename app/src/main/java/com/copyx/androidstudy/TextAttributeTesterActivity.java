package com.copyx.androidstudy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextAttributeTesterActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView outputTextView;
    private RadioGroup textStyleRadioGroup;
    private CheckBox boldCheckBox;
    private CheckBox italicCheckBox;
    private CheckBox autoLinkCheckBox;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text_attribute_tester);

        inputEditText = findViewById(R.id.input_edit_text);
        outputTextView = findViewById(R.id.output_text_view);
        textStyleRadioGroup = findViewById(R.id.text_style_radio_group);
        boldCheckBox = findViewById(R.id.bold_check_box);
        italicCheckBox = findViewById(R.id.italic_check_box);
        autoLinkCheckBox = findViewById(R.id.auto_link_check_box);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                outputTextView.setText(s);
            }
        });

        textStyleRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case 1:
                        inputEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                        break;

                    case 2:
                        inputEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                        break;

                    case 3:
                        inputEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                        break;

                    default:
                        inputEditText.setInputType(InputType.TYPE_NULL);
                }
            }
        });

        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setTextStyleOnOutputTextView(isChecked, italicCheckBox.isChecked());
            }
        });

        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setTextStyleOnOutputTextView(italicCheckBox.isChecked(), isChecked);
            }
        });

        autoLinkCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            TextWatcher autoLinkWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) { }

                @Override
                public void afterTextChanged(Editable s) {
                    Linkify.addLinks(outputTextView, Linkify.ALL);
                }
            };

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    outputTextView.addTextChangedListener(autoLinkWatcher);
                } else {
                    outputTextView.removeTextChangedListener(autoLinkWatcher);
                }

                outputTextView.setText(inputEditText.getText());
            }
        });
    }

    private void setTextStyleOnOutputTextView(boolean bold, boolean italic) {
        if (bold && italic) {
            outputTextView.setTypeface(null, Typeface.BOLD_ITALIC);
        } else if (bold) {
            outputTextView.setTypeface(null, Typeface.BOLD);
        } else if (italic) {
            outputTextView.setTypeface(null, Typeface.ITALIC);
        } else {
            outputTextView.setTypeface(null, Typeface.NORMAL);
        }
    }
}
