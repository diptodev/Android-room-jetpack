import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.excitedbroltd.androidroomjetpack.model.NoteModel

@Composable

fun myNote(noteModel: NoteModel, onclick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onclick()
            },
        colors = CardDefaults.cardColors(containerColor = Color.Cyan.copy(alpha = 0.4f)),
        content = {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = noteModel.title,
                Modifier

                    .fillMaxWidth()
                    .padding(5.dp)
            )

            Text(
                text = noteModel.desc, Modifier

                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        })
}

@Composable
@Preview()
fun showPreview() {
    myNote(
        noteModel = NoteModel(
            0,
            234241234L,
            "This is new note",
            "This is new note This is new note This is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new noteThis is new note"
        )
    ) {

    }
}