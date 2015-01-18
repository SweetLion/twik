/*
 * Copyright 2014 Red Dye No. 2
 *
 * This file is part of Twik.
 *
 * Twik is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Twik is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Twik.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.reddyetwo.hashmypass.app.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ButtonsEnableTextWatcher implements TextWatcher {

    private final AutoCompleteTextView mTagEditText;
    private final EditText mMasterKeyEditText;
    private final ImageButton mTagSettingsButton;
    private final Button mHashButton;

    public ButtonsEnableTextWatcher(AutoCompleteTextView tagEditText,
                                    EditText masterKeyEditText,
                                    ImageButton tagSettingsButton,
                                    Button hashButton) {
        mTagEditText = tagEditText;
        mMasterKeyEditText = masterKeyEditText;
        mTagSettingsButton = tagSettingsButton;
        mHashButton = hashButton;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // Do nothing
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
        // Do nothing
    }

    @Override
    public void afterTextChanged(Editable s) {
        updateTagSettingsButtonEnabled();
        updateHashButtonEnabled();
    }

    void updateHashButtonEnabled() {
        boolean tagSet = mTagEditText.getText().toString().trim().length() > 0;
        boolean masterKeySet =
                mMasterKeyEditText.length() > 0;
        mHashButton.setEnabled(tagSet && masterKeySet);
    }

    void updateTagSettingsButtonEnabled() {
        boolean tagSet = mTagEditText.getText().toString().trim().length() > 0;
        mTagSettingsButton.setEnabled(tagSet);
        if (tagSet) {
            mTagSettingsButton.setVisibility(View.VISIBLE);
        } else {
            mTagSettingsButton.setVisibility(View.INVISIBLE);
        }
    }


}

