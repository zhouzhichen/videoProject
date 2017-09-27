package uploadServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import userDao.UserDao;
import vedioBean.VedioBean;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VedioBean vb = new VedioBean();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
		String savepath1 = this.getServletContext().getRealPath("/images");

		File file = new File(savepath);
		if (!file.exists() && file.isDirectory()) {
			file.mkdir();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			return;
		}

		// 方法1
		// 给ServletFileUpload添加监听事件
		upload.setProgressListener(new ProgressListener() {// 匿名实现监听接口

			@Override
			public void update(long arg0, long arg1, int arg2) {// arg2为上传文件的位数
				double size0 = Double.parseDouble(arg0 + "");// 为上传了多少文件
				double size1 = Double.parseDouble(arg1 + "");// 总共要上传多少文件

				request.getSession().setAttribute("progress", (int) (arg0 * 100 / arg1));

			}

		});

		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {// 判断是否是普通类型
					if (item.getFieldName().equals("sk2")) {// item.getFieldName()得到的是name属性的值
						vb.setVedio_name(item.getString());
					}
					if (item.getFieldName().equals("sk4")) {
						vb.setVedio_msg(item.getString());
					}
					// String name = item.getFieldName();
				 String value = item.getString("utf-8");

				} else {
					if (item.getFieldName().equals("sk1")) {

						String filename = item.getName();// 得到的是文件的绝对路径
						System.out.println(filename);
						if (filename == null || filename.trim().equals("")) {
							continue;
						}
						filename = filename.substring(filename.lastIndexOf("\\") + 1);

						InputStream in = item.getInputStream();

						FileOutputStream out = new FileOutputStream(savepath + "\\" + filename);
						vb.setVedio_url(".." + "/" + "videos" + "/" + filename);
						byte buffer[] = new byte[1024];
						int len = 0;
						// 添加监听事件的方法2(不建议使用),注释部分
						// long length = 0;
						// long lol=in.available();//获取文件总长度
						while ((len = in.read(buffer)) != -1) {

							out.write(buffer, 0, len);
							// length+=len;//获取文件写入了多长
							// int x=(int) (length*100/lol);
							// System.out.println(x);
							// request.getSession().setAttribute("progress", x);
						}
						out.flush();
						in.close();
						out.close();
						item.delete();
					}
					if (item.getFieldName().equals("sk3")) {

						String filename = item.getName();
						if (filename == null || filename.trim().equals("")) {// 去掉两头的空格
							continue;

						}
						filename = filename.substring(filename.lastIndexOf("\\") + 1);

						InputStream in = item.getInputStream();

						FileOutputStream out = new FileOutputStream(savepath1 + "\\" + filename);
						vb.setVedio_img_url("images" + "/" + filename);
						byte buffer[] = new byte[1024];
						int len = 0;
						while ((len = in.read(buffer)) != -1) {

							out.write(buffer, 0, len);
						}
						out.flush();
						in.close();
						out.close();
						item.delete();
					}

				}

			}

		}

		catch (

		FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		java.sql.Timestamp day = new java.sql.Timestamp(date.getTime());// util和sql语句的Date转换,sql语句中必须放long类型的参数
		vb.setVedio_upload_time(day);
		vb.setVedio_user_id((int) request.getSession().getAttribute("shit"));
		vb.setVedio_major_id((int) request.getSession().getAttribute("fuck"));
		UserDao.insert(vb);
		request.getRequestDispatcher("upload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
