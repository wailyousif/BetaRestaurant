INSERT INTO address (id, address_line1, address_line2, city, country, lat, lng, state, street, zip_code) VALUES (-1, 'Debonairs Tower', null, 'Khartoum', 'Sudan', 0, 0, 'KRT', 'Airport St.', '33411');
INSERT INTO contact_info (id, email, phone, address_id) VALUES (-1, 'wail@hotmail.com', '+249901239310', -1);

INSERT INTO restaurant_owner (id, name, contact_info_id) VALUES (-1, 'Wail Mohamed', -1);
INSERT INTO restaurant (id, arabic_name, english_name, logo_file, hq_address_id, owner_id) VALUES (-1, 'ديبونيرز', 'Debonairs', 'debonairs.jpg', -1, -1);
INSERT INTO restaurant_branch (id, arabic_name, english_name, address_id, branch_manager_id, restaurant_id) VALUES (-1, 'فرع الستين', '60 Branch', -1, null, -1);

INSERT INTO user_role (id, default_page, description, role) VALUES (-1, 'owner.jsp', 'Owner-Page', 'OWNER');
INSERT INTO user_role (id, default_page, description, role) VALUES (-2, 'cashier.jsp', 'Cashier Page', 'CASHIER');
INSERT INTO user_role (id, default_page, description, role) VALUES (-3, 'stock.jsp', 'Stock Management Page', 'STOCK_MANAGER');

INSERT INTO app_user (id, creation_time, display_name, enabled, password, username, created_by_id, employee_id, restaurant_branch_id, user_role_id) VALUES (-1, '2017-06-10 18:50:36.777000', 'Wail MY', true, 'We+sNJEng9p6ykLezqhim84+RPwL37aEAuaDt6qE9gL7cl7ff+gawahkn+AMYNZ90zC49cakVy86sY4YZuexxw==', 'wail', null, null, -1, -1);

INSERT INTO public.system_language (id, language) VALUES (1, 'Arabic');
INSERT INTO public.system_language (id, language) VALUES (2, 'English');

INSERT INTO public.cost_category (code, user_defined) VALUES ('GOVERNMENTAL', false);
INSERT INTO public.cost_category (code, user_defined) VALUES ('PAYROLL', false);
INSERT INTO public.cost_category (code, user_defined) VALUES ('RENTAL', false);
INSERT INTO public.cost_category (code, user_defined) VALUES ('UTILITIES', false);
INSERT INTO public.cost_category (code, user_defined) VALUES ('OTHERS', false);

INSERT INTO public.cost_category_trans (lang_code, lang_description, cost_category_code, language_id) VALUES ('رسوم حكومية', 'عوائد، ضرائب، الخ.', 'GOVERNMENTAL', 1);
INSERT INTO public.cost_category_trans (lang_code, lang_description, cost_category_code, language_id) VALUES ('موظفين', 'مرتبات، بدلات، حوافز للموظفين', 'PAYROLL', 1);
INSERT INTO public.cost_category_trans (lang_code, lang_description, cost_category_code, language_id) VALUES ('ايجارات', 'ايجار محل أو مخزن', 'RENTAL', 1);
INSERT INTO public.cost_category_trans (lang_code, lang_description, cost_category_code, language_id) VALUES ('خدمات', 'كهرباء، ماء، غاز، الخ.', 'UTILITIES', 1);
INSERT INTO public.cost_category_trans (lang_code, lang_description, cost_category_code, language_id) VALUES ('منصرفات أخرى', 'منصرفات أخرى', 'OTHERS', 1);

INSERT INTO public.job_type (code, user_defined) VALUES ('COOK', false);
INSERT INTO public.job_type (code, user_defined) VALUES ('WAITER', false);
INSERT INTO public.job_type (code, user_defined) VALUES ('CASHIER', false);
INSERT INTO public.job_type (code, user_defined) VALUES ('ACCOUNTANT', false);
INSERT INTO public.job_type (code, user_defined) VALUES ('SUPERVISOR', false);
INSERT INTO public.job_type (code, user_defined) VALUES ('CLEANER', false);
INSERT INTO public.job_type (code, user_defined) VALUES ('OTHERS', false);

INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('طباخ', 'طباخ', 'COOK', 1);
INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('جرسون', 'جرسون', 'WAITER', 1);
INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('كاشير', 'كاشير', 'CASHIER', 1);
INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('محاسب', 'محاسب', 'ACCOUNTANT', 1);
INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('مشرف', 'مشرف', 'SUPERVISOR', 1);
INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('عامل نظافة', 'عامل نظافة', 'CLEANER', 1);
INSERT INTO public.job_type_trans (lang_code, lang_description, job_type_code, language_id) VALUES ('أخرى', 'أخرى', 'OTHERS', 1);

INSERT INTO public.salary_frequency (code, user_defined) VALUES ('DAILY', false);
INSERT INTO public.salary_frequency (code, user_defined) VALUES ('WEEKLY', false);
INSERT INTO public.salary_frequency (code, user_defined) VALUES ('MONTHLY', false);

INSERT INTO public.salary_frequency_trans (lang_code, lang_description, language_id, salary_frequency_code) VALUES ('يومي', 'يومي', 1, 'DAILY');
INSERT INTO public.salary_frequency_trans (lang_code, lang_description, language_id, salary_frequency_code) VALUES ('أسبوعي', 'أسبوعي', 1, 'WEEKLY');
INSERT INTO public.salary_frequency_trans (lang_code, lang_description, language_id, salary_frequency_code) VALUES ('شهري', 'شهري', 1, 'MONTHLY');

INSERT INTO public.quantification_method (code, user_defined) VALUES ('GRAMS', false);
INSERT INTO public.quantification_method (code, user_defined) VALUES ('KILOGRAMS', false);
INSERT INTO public.quantification_method (code, user_defined) VALUES ('QUANTITY', false);

INSERT INTO public.quantification_method_trans (lang_code, lang_description, language_id, quantification_method_code) VALUES ('جم', 'جرام', 1, 'GRAMS');
INSERT INTO public.quantification_method_trans (lang_code, lang_description, language_id, quantification_method_code) VALUES ('كجم', 'كيلو جرام', 1, 'KILOGRAMS');
INSERT INTO public.quantification_method_trans (lang_code, lang_description, language_id, quantification_method_code) VALUES ('حبة', 'حبة أو قطعة', 1, 'QUANTITY');

INSERT INTO public.recurrence (code, user_defined) VALUES ('AD-HOC', false);
INSERT INTO public.recurrence (code, user_defined) VALUES ('DAILY', false);
INSERT INTO public.recurrence (code, user_defined) VALUES ('WEEKLY', false);
INSERT INTO public.recurrence (code, user_defined) VALUES ('MONTHLY', false);
INSERT INTO public.recurrence (code, user_defined) VALUES ('QUARTERLY', false);
INSERT INTO public.recurrence (code, user_defined) VALUES ('BI-ANNUAL', false);
INSERT INTO public.recurrence (code, user_defined) VALUES ('ANNUAL', false);

INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('لحظي', 'لحظي', 1, 'AD-HOC');
INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('يومي', 'يومي', 1, 'DAILY');
INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('أسبوعي', 'أسبوعي', 1, 'WEEKLY');
INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('شهري', 'شهري', 1, 'MONTHLY');
INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('ربع سنوي', 'ربع سنوي', 1, 'QUARTERLY');
INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('نصف سنوي', 'نصف سنوي', 1, 'BI-ANNUAL');
INSERT INTO public.recurrence_trans (lang_code, lang_description, language_id, recurrence_code) VALUES ('سنوي', 'سنوي', 1, 'ANNUAL');

INSERT INTO public.sales_item_type (code, user_defined) VALUES ('SANDWISH', false);
INSERT INTO public.sales_item_type (code, user_defined) VALUES ('APPETIZER', false);
INSERT INTO public.sales_item_type (code, user_defined) VALUES ('DISH', false);
INSERT INTO public.sales_item_type (code, user_defined) VALUES ('DESERT', false);
INSERT INTO public.sales_item_type (code, user_defined) VALUES ('DRINK', false);
INSERT INTO public.sales_item_type (code, user_defined) VALUES ('PASTRY', false);
INSERT INTO public.sales_item_type (code, user_defined) VALUES ('OTHER', false);

INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('سندوتش', 'سندوتش', 1, 'SANDWISH');
INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('طبق', 'طبق', 1, 'DISH');
INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('معجنات', 'معجنات', 1, 'PASTRY');
INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('تحلية', 'تحلية', 1, 'DESERT');
INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('مشروب', 'مشروب', 1, 'DRINK');
INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('مقبلات', 'مقبلات', 1, 'APPETIZER');
INSERT INTO public.sales_item_type_trans (lang_code, lang_description, language_id, sales_item_type_code) VALUES ('أخرى', 'أخرى', 1, 'OTHER');
