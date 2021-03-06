package retrofit.android;

import android.util.Log;
import retrofit.RestAdapter;

/** A {@link RestAdapter.Log logger} for Android. */
public class AndroidLog implements RestAdapter.Log {
  private static final int LOG_CHUNK_SIZE = 4000;

  private final String tag;

  public AndroidLog(String tag) {
    this.tag = tag;
  }

  @Override public void log(String message) {
    for (int i = 0, len = message.length(); i < len; i += LOG_CHUNK_SIZE) {
      int end = Math.min(len, i + LOG_CHUNK_SIZE);
      logChunk(message.substring(i, end));
    }
  }

  public void logChunk(String chunk) {
    Log.d(getTag(), chunk);
  }

  public String getTag() {
    return tag;
  }
}
