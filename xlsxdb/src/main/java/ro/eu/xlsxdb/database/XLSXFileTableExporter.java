package ro.eu.xlsxdb.database;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;

import ro.eu.xlsxdb.xlsxloader.XLSXRow;

public class XLSXFileTableExporter {
	private final static Logger logger = Logger.getLogger(XLSXFileTableExporter.class);
	private XLSXFileTable xlsxFileTable;

	public XLSXFileTableExporter(XLSXFileTable xlsxFileTable) {
		this.xlsxFileTable = xlsxFileTable;
	}

	public Path exportXLSXFileTableToSQLScript(String filePath)
			throws FileNotFoundException, UnsupportedEncodingException {
		logger.info("Exporting " + filePath + " ...");
		try (PrintWriter writer = new PrintWriter(Paths.get(filePath).toFile(), "UTF-8")) {
			writer.println(SQLQueriesUtils.generateSQLCreateTable(xlsxFileTable));
			writer.println(" ");
			List<XLSXRow> rows = xlsxFileTable.getRows();
			for (XLSXRow row : rows) {
				writer.println(SQLQueriesUtils.generateSQLInsertRow(xlsxFileTable.getTableName(),
						xlsxFileTable.getColumns(), row));
			}
		}
		;
		return Paths.get(filePath);
	}
}
