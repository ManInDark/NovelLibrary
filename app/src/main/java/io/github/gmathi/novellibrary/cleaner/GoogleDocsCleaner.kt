package io.github.gmathi.novellibrary.cleaner

import android.net.Uri
import io.github.gmathi.novellibrary.network.HostNames
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.File

class GoogleDocsCleaner : HtmlHelper() {

    override fun downloadCSS(doc: Document, downloadDir: File) {
        removeCSS(doc)
    }

    override fun additionalProcessing(doc: Document) {
        doc.getElementsByTag("link")?.remove()
        doc.getElementsByTag("style")?.remove()
    }

    override fun downloadImage(element: Element, dir: File): File? {
        val uri = Uri.parse(element.attr("src"))
        return if (uri.toString().contains("uploads/avatars")) null
        else super.downloadImage(element, dir)
    }
}