package com.fishing.namtran.fishingmanagerservice;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ManagerCustomerActivity extends BaseMenuActivity { //BaseMenuActivity

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_manager_customer);

        setContentView(R.layout.activity_manager_customer);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        //intent = new Intent(getApplicationContext(), MenuMainActivity.class);
       // startActivity(intent);
    }
*/

    /*
    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_customer);
        tableLayout=(TableLayout)findViewById(R.id.tableLayout);

        for (int i=0;i<5;i++){
            View tableRow = LayoutInflater.from(this).inflate(R.layout.items_customer,null,false);
            TextView history_display_no  = (TextView) tableRow.findViewById(R.id.history_display_no);
            TextView history_display_date  = (TextView) tableRow.findViewById(R.id.history_display_date);
            TextView history_display_orderid  = (TextView) tableRow.findViewById(R.id.history_display_orderid);
            TextView history_display_quantity  = (TextView) tableRow.findViewById(R.id.history_display_quantity);

            history_display_no.setText(""+(i+1));
            history_display_date.setText("2014-02-05");
            history_display_orderid.setText("S0"+(i+1));
            history_display_quantity.setText(""+(20+(i+1)));
            tableLayout.addView(tableRow);
        }
    }
    */
//https://stackoverflow.com/questions/21568835/how-to-dispaly-result-list-into-tablelayout-row-in-androi
// https://stackoverflow.com/questions/31353447/how-to-list-all-the-rows-in-a-table-using-sqlite-in-android-studio-using-cursor

    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroller_customers);

        TableRow.LayoutParams wrapWrapTableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        int[] fixedColumnWidths = new int[]{20, 20, 20, 20, 20};
        int[] scrollableColumnWidths = new int[]{20, 20, 20, 30, 30};
        int fixedRowHeight = 50;
        int fixedHeaderHeight = 60;

        TableRow row = new TableRow(this);
        //header (fixed vertically)
        TableLayout header = (TableLayout) findViewById(R.id.table_header);
        row.setLayoutParams(wrapWrapTableRowParams);
        row.setGravity(Gravity.CENTER);
        row.setBackgroundColor(Color.YELLOW);
        row.addView(makeTableRowWithText("col 1", fixedColumnWidths[0], fixedHeaderHeight));
        row.addView(makeTableRowWithText("col 2", fixedColumnWidths[1], fixedHeaderHeight));
        row.addView(makeTableRowWithText("col 3", fixedColumnWidths[2], fixedHeaderHeight));
        row.addView(makeTableRowWithText("col 4", fixedColumnWidths[3], fixedHeaderHeight));
        row.addView(makeTableRowWithText("col 5", fixedColumnWidths[4], fixedHeaderHeight));
        header.addView(row);
        //header (fixed horizontally)
        TableLayout fixedColumn = (TableLayout) findViewById(R.id.fixed_column);
        //rest of the table (within a scroll view)
        TableLayout scrollablePart = (TableLayout) findViewById(R.id.scrollable_part);
        for(int i = 0; i < 100; i++) {
            TextView fixedView = makeTableRowWithText("row number " + i, scrollableColumnWidths[0], fixedRowHeight);
            fixedView.setBackgroundColor(Color.BLUE);
            fixedColumn.addView(fixedView);
            row = new TableRow(this);
            row.setLayoutParams(wrapWrapTableRowParams);
            row.setGravity(Gravity.CENTER);
            row.setBackgroundColor(Color.WHITE);
            row.addView(makeTableRowWithText("value 2", scrollableColumnWidths[1], fixedRowHeight));
            row.addView(makeTableRowWithText("value 3", scrollableColumnWidths[2], fixedRowHeight));
            row.addView(makeTableRowWithText("value 4", scrollableColumnWidths[3], fixedRowHeight));
            row.addView(makeTableRowWithText("value 5", scrollableColumnWidths[4], fixedRowHeight));
            scrollablePart.addView(row);
        }

    }
    //util method
    private TextView recyclableTextView;

    public TextView makeTableRowWithText(String text, int widthInPercentOfScreenWidth, int fixedHeightInPixels) {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        recyclableTextView = new TextView(this);
        recyclableTextView.setText(text);
        recyclableTextView.setTextColor(Color.BLACK);
        recyclableTextView.setTextSize(20);
        recyclableTextView.setWidth(widthInPercentOfScreenWidth * screenWidth / 100);
        recyclableTextView.setHeight(fixedHeightInPixels);
        return recyclableTextView;
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_customer);

        B b[] = new B[] {
                new B(getString(R.string.simple_adapter), SimpleTable.class),
                new B(getString(R.string.style_adapter), StyleTable.class),
                new B(getString(R.string.family_adapter), FamilyTable.class),
        };
        //ListActivity a = new ListActivity();
        //a.setListAdapter(new ArrayAdapter<B>(this, android.R.layout.simple_list_item_1, android.R.id.text1, b));

        Intent intent = new Intent(getApplicationContext(), FamilyTable.class);
        startActivity(intent);
    }

    //@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, ((B) l.getItemAtPosition(position)).class1));
    }

    private class B {
        private final String string;
        private final Class<? extends Activity> class1;

        B(String string, Class<? extends Activity> class1) {
            this.string = string;
            this.class1 = class1;
        }

        @Override
        public String toString() {
            return string;
        }
    }

}
