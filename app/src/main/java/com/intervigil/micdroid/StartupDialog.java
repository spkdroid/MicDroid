/* StartupDialog.java

   Copyright (c) 2010 Ethan Chen

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License along
   with this program; if not, write to the Free Software Foundation, Inc.,
   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.intervigil.micdroid;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class StartupDialog extends Dialog {

    private Context mContext;
    private int mTitleId;
    private int mTextId;
    private int mButtonLabelId;

    public StartupDialog(Context context, int titleId, int textId,
                         int buttonLabelId) {
        super(context);
        mContext = context;
        mTitleId = titleId;
        mTextId = textId;
        mButtonLabelId = buttonLabelId;

        View dialog = createDialog();
        setContentView(dialog);
    }

    private View createDialog() {
        // Set title text
        setTitle(mTitleId);

        // Create the overall layout.
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(6, 6, 6, 6);

        // Create a ScrollView to put the text in. Shouldn't be necessary...
        ScrollView tScroll = new ScrollView(mContext);
        tScroll.setVerticalScrollBarEnabled(true);
        tScroll.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        layout.addView(tScroll);

        // Now create the text view and add it to the scroller.
        TextView textView = new TextView(mContext);
        textView.setTextSize(16);
        textView.setTextColor(0xffffffff);
        textView.setText(mTextId);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT));
        tScroll.addView(textView);

        // Add a layout to hold the buttons.
        LinearLayout buttonHolder = new LinearLayout(mContext);
        buttonHolder.setBackgroundColor(0xf08080);
        buttonHolder.setOrientation(LinearLayout.HORIZONTAL);
        buttonHolder.setPadding(6, 3, 3, 3);
        layout.addView(buttonHolder, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        // Add the OK button.
        Button btn = new Button(mContext);
        btn.setText(mButtonLabelId);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });
        buttonHolder.addView(btn, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        return layout;
    }
}
