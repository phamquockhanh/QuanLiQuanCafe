package com.example.ribon.quanliquancafe.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.loader.CategoryDao;
import com.example.ribon.quanliquancafe.loader.ProductDao;
import com.example.ribon.quanliquancafe.model.Category;
import com.example.ribon.quanliquancafe.model.Product;
import com.example.ribon.quanliquancafe.model.Table;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MEDIA_PROJECTION_SERVICE;

/**
 * Created by Ribon on 19/03/2017.
 */

public class InsertProductFragment extends BaseFragment {
    private String selectedImagePath;
    @Bind(R.id.spinner)
    Spinner spinner;
    public static final int RESULT_GALLERY = 0;
    List<String>itemSpinner;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.edtName)
    EditText edtNameProduct;
    @Bind(R.id.edtPrice)
    EditText edtPrice;
    @Bind(R.id.edtquar)
    EditText edtQuarity;
    String path;
    String categoryName;
    ArrayAdapter<Category> adapter;

    @Override
    public int getResId() {
        return R.layout.fragment_insert_product;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CategoryDao categoryDao=new CategoryDao(getActivity());
        List<Category> categories=categoryDao.getAll();
        adapter = new ArrayAdapter<Category>(getActivity(), R.layout.support_simple_spinner_dropdown_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @OnClick(R.id.btnChoose)
    void selectimage(){
        Intent galleryIntent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent , RESULT_GALLERY );
    }
    @OnClick(R.id.btnAdd)
    void saveProducṭ̣̣̣̣̣̣(){
        Category category = (Category) spinner.getSelectedItem();

        Product product=new Product();
        product.setName(edtNameProduct.getText().toString());
        product.setPrice(Float.parseFloat(edtPrice.getText().toString()));
        product.setPath(path);
        product.setCategories(category);
        product.setQuantity(Integer.parseInt(edtQuarity.getText().toString()));
        ProductDao productDao=new ProductDao(getActivity());
        productDao.create(product);

        Toast.makeText(getActivity(), "luu thanh cong"+product.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==RESULT_GALLERY && resultCode==RESULT_OK && data!=null){
            try {
                final Uri imageUri=data.getData();
                final InputStream imagesStream=getActivity().getContentResolver().openInputStream(imageUri);
                final Bitmap selectImage=BitmapFactory.decodeStream(imagesStream);
                imageView.setImageBitmap(selectImage);
                path=getRealPathFromURI(imageUri);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();

            }
           /* Uri pickedImage=data.getData();
            String[] filePath={MediaStore.Images.Media.DATA};
            Cursor cursor=getActivity().getContentResolver().query(pickedImage,filePath,null,null,null);
            cursor.moveToFirst();
            String imagePath=cursor.getString(cursor.getColumnIndex(filePath[0]));
            imageView.setImageBitmap(BitmapFactory.decodeFile(imagePath));
            cursor.close();
            path=getRealPathFromURI(pickedImage);*/

        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getActivity().getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
}
