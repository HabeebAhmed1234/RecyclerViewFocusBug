package tegrazone.nvidia.com.recyclerviewfocusbug;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button focusRequestButton  = ((Button) findViewById(R.id.focus_request_button));
        final RecyclerView recycler  = ((RecyclerView) findViewById(R.id.recyclerview));

        focusRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycler.requestFocus();
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);

        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                Button button = new Button(MainActivity.this);
                button.setText("inside RecyclerView");
                RecyclerView.ViewHolder vh = new RecyclerView.ViewHolder(button) {
                };
                return vh;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return 1;
            }
        };

        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
