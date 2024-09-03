import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.github.fioshi.ItemsViewModel
import com.github.fioshi.R

class MainActivity : AppCompatActivity() {

    val viewModel: ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            viewModel.addItem(editText.text.toString())
            editText.text.clear()

            viewModel.itemsLiveData.observe(this) {
                items -> itemsAdapter.updateItems(items)

            }
        }
    }
}