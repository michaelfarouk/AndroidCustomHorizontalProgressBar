package customProgressbar.personalApps.com.androidcustomhorizontalprogressbar;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    private ProgressBar customProgress;
    private ProgressBar secondCustomProgress;
    private TextView progressDisplay;
    private TextView secondProgressDispaly;
    private ProgressBar thirdCustomProgress;
    private TextView thirdProgressDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
    }

    /**
     * Initialize UI view components
     */
    private void init() {
        customProgress = (ProgressBar)findViewById(R.id.customProgress);
        progressDisplay = (TextView)findViewById(R.id.progressDisplay);

        secondCustomProgress = (ProgressBar)findViewById(R.id.secondCustomProgress);
        secondProgressDispaly = (TextView)findViewById(R.id.secondProgressDisplay);

        thirdCustomProgress = (ProgressBar)findViewById(R.id.thirdCustomProgress);
        thirdProgressDisplay = (TextView)findViewById(R.id.thirdProgressDisplay);
    }

    /**
     * Initialize data || start actions
     */
    private void initData() {

        new ShowCustomProgressBarAsyncTask().execute();

    }

    /**
     * Progress bar increment and display current state
     */
    public class ShowCustomProgressBarAsyncTask extends AsyncTask<Void, Integer, Void> {

        int myProgress;

        @Override
        protected void onPreExecute() {
            myProgress = 0;
        }

        @Override
        protected Void doInBackground(Void... params) {
            while(myProgress<100){
                myProgress++;
                publishProgress(myProgress);
                SystemClock.sleep(200);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            customProgress.setProgress(values[0]);
            customProgress.setSecondaryProgress(values[0] + 1);
            progressDisplay.setText(String.valueOf(myProgress)+"%");

            secondCustomProgress.setProgress(values[0]+15);
            secondCustomProgress.setSecondaryProgress(values[0] + 16);
            secondProgressDispaly.setText(String.valueOf(myProgress+15)+"%");

            thirdCustomProgress.setProgress(values[0]+7);
            thirdCustomProgress.setSecondaryProgress(values[0] + 8);
            thirdProgressDisplay.setText(String.valueOf(myProgress + 7)+"%");
        }

        @Override
        protected void onPostExecute(Void result) {

        }
    }
}
